
package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;
/*
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
*/
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.usfirst.frc6647.Voltres.autonomous_step.AutonomousStep_Lift;
import org.usfirst.frc6647.Voltres.autonomous_step.AutonomousStep_TilTake;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Autonomous_Robot extends Subsystem {

    private static final double TOLERANCE=0.15;  //tolerancia del joystick(quita el error)
	private static final double LIMITER=0.8;  //Por si quieren limitar la velocidad del drive
    private static int direction = 1;  //para invertir los ejes si necesario
    private static WPI_TalonSRX lefTalon;
    private static WPI_TalonSRX righTalon;
    private static WPI_TalonSRX hWheel;
    private static Solenoid frontCylinderRev;
    private static Solenoid frontCylinderFwd;
    private static Solenoid backCylinderRev;
    private static Solenoid backCylinderFwd;

    private static WPI_TalonSRX cylWheel;
    /*
    private static WPI_VictorSPX cylWheel;
    */


    private static DifferentialDrive diffDrive;


    //private static double statepiston=1;

    public Autonomous_Robot() {

        lefTalon = RobotMap.frontLeft;
        righTalon = RobotMap.frontRight;

        diffDrive = new DifferentialDrive( lefTalon, righTalon);

        cylWheel = RobotMap.cylinderWheels;

        frontCylinderFwd = RobotMap.frontCylinderFoward;
        frontCylinderRev = RobotMap.frontCylinderReverse;
        backCylinderFwd = RobotMap.backCylinderFoward;
        backCylinderRev = RobotMap.backCylinderReverse;

        hWheel = RobotMap.hWheel;

        //diffDrive.setRightSideInverted(false);
        //diffDrive.setExpiration(0.02);
		//diffDrive.setSafetyEnabled(false);

    }

    @Override
    public void initDefaultCommand() {
        Main_Drive();
    }

    public void Main_Drive(){
        Joystick joystick = Robot.oi.joystick1;

        double  LeftStickY=mapDoubleT(joystick.getRawAxis(0),TOLERANCE,1,0,1)*direction*-1, 
                LeftStickX=mapDoubleT(joystick.getRawAxis(1),TOLERANCE,1,0,1)*direction,
                RightStickX=mapDoubleT(joystick.getRawAxis(2), TOLERANCE, 1, 0, 1)*direction;

        diffDrive.arcadeDrive(LeftStickY*LIMITER, LeftStickX*LIMITER);
        hWheel.set(ControlMode.PercentOutput, RightStickX);

        SmartDashboard.putNumber("EncoderL chassis", lefTalon.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("EncoderR chassis", righTalon.getSelectedSensorPosition(0));
    }

    public double getSensorL(){
        return lefTalon.getSelectedSensorPosition(0);
    }

    public double getSensorR(){
        return righTalon.getSelectedSensorPosition(0);
    }

    private double mapDoubleT(double x, double in_min, double in_max, double out_min, double out_max)
	{
		if(Math.abs(x)<TOLERANCE) {
			return 0;
		}
		if(x<0){
			return map(x,-in_min,-in_max,-out_min,-out_max);
		}
		return map(x,in_min,in_max,out_min,out_max);
    }

    private double map(double x, double in_min, double in_max, double out_min, double out_max)
	{
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    
    public void HAB_Control(){
        /*
        if(statepiston==1) {
			HAB_Up();
			statepiston=statepiston*-1;
		}else {
			HAB_Down();
			statepiston=statepiston*-1;
        }
        */
    }

    public void HABFront_Up(){
        frontCylinderFwd.set(true);
        frontCylinderRev.set(false);
    }

    public void HABFront_Down(){
        frontCylinderFwd.set(false);
        frontCylinderRev.set(true);
    }

    public void HABBack_Up(){
        backCylinderFwd.set(true);
        backCylinderRev.set(false);
    }

    public void HABBack_Down(){
        backCylinderFwd.set(false);
        backCylinderRev.set(true);
    }

    public void HAB_Front(){
        cylWheel.set(ControlMode.PercentOutput, 0.3);
    }

    public void HAB_Back(){
        cylWheel.set(ControlMode.PercentOutput, 0.3);
    }
    
    @Override
    public void periodic() {
        // Put code here to be run every loop
        SmartDashboard.putNumber("EncoderL chassis", lefTalon.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("EncoderR chassis", righTalon.getSelectedSensorPosition(0));
    }

    public void Stop_Drive(){
        lefTalon.set(ControlMode.PercentOutput, 0.0);
        righTalon.set(ControlMode.PercentOutput, 0.0);
    }

}

