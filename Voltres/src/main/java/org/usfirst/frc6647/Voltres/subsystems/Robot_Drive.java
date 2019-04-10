// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;
import org.usfirst.frc6647.Voltres.OI;

/*
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
*/
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot_Drive extends Subsystem {

    private static final double TOLERANCE=0.15;  //tolerancia del joystick(quita el error)
	private static double LIMITER = 0.75;  //Por si quieren limitar la velocidad del drive
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


    //private static DifferentialDrive diffDrive;


    //private static double statepiston=1;

    public Robot_Drive() {

        lefTalon = RobotMap.frontLeft;
        righTalon = RobotMap.frontRight;

        //diffDrive = new DifferentialDrive( lefTalon, righTalon);

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

        int angle = Robot.oi.joystick1.getPOV();
        Joystick joystick = Robot.oi.joystick1;

        // For Differential Drive


        /*
        double  LeftStickY=mapDoubleT(joystick.getRawAxis(0),TOLERANCE,1,0,1)*direction*-1, 
                LeftStickX=mapDoubleT(joystick.getRawAxis(1),TOLERANCE,1,0,1)*direction,
                RightStickX=mapDoubleT(joystick.getRawAxis(2), TOLERANCE, 1, 0, 1);

                diffDrive.arcadeDrive(LeftStickY*LIMITER, LeftStickX*LIMITER*0.8);

                hWheel.set(ControlMode.PercentOutput, RightStickX);
        */
    

                //////////////////////////////////////

        //For Tank Drive/////////////


        
        double  LeftStickY=mapDoubleT(joystick.getRawAxis(1),TOLERANCE,1,0,1)*direction, 
            RightStickY=mapDoubleT(joystick.getRawAxis(5),TOLERANCE,1,0,1)*direction,
            analogLT= (joystick.getRawAxis(3) + 1)/2,
            analogRT=(joystick.getRawAxis(4) + 1)/2;

            if (Robot.oi.Button7.get()){
                hWheel.set(ControlMode.PercentOutput, -analogLT*0.7);
            }else if(Robot.oi.Button4.get()){
                hWheel.set(ControlMode.PercentOutput, Robot.vision.limitOutput());
            }
            else{ if (Robot.oi.Button8.get()){
                hWheel.set(ControlMode.PercentOutput, analogRT*0.7);
                }
                else{
                    hWheel.set(ControlMode.PercentOutput, 0);
                }
            }

            if (angle==-1){
                lefTalon.set(ControlMode.PercentOutput,LeftStickY*LIMITER*0.95);
                righTalon.set(ControlMode.PercentOutput,RightStickY*LIMITER);
            }else {
                if(angle == 0){
                    lefTalon.set(ControlMode.PercentOutput,-0.8*LIMITER*0.95);
                    righTalon.set(ControlMode.PercentOutput,-0.8*LIMITER);
            }
                else{ if(angle == 180){
                lefTalon.set(ControlMode.PercentOutput,0.8*LIMITER*0.95);
                righTalon.set(ControlMode.PercentOutput,0.8*LIMITER);
            }
            }
        }
        
        
        /////////////////////////////////////
        

        SmartDashboard.putNumber("EncoderL chassis", lefTalon.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("EncoderR chassis", righTalon.getSelectedSensorPosition(0));
        //SmartDashboard.putNumber("LT Value", analogLT);
        //SmartDashboard.putNumber("RT Value", analogRT);
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
    public void HABFront_Stop(){
        frontCylinderFwd.set(true);
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

    public void HABBack_Stop(){
        backCylinderFwd.set(true);
        backCylinderRev.set(true);
    }

    public void HAB_Front(){
        cylWheel.set(ControlMode.PercentOutput, 0.7);
    }

    public void HAB_Back(){
        cylWheel.set(ControlMode.PercentOutput, -0.7);
    }

    public void HAB_Stop(){
        cylWheel.set(ControlMode.PercentOutput, 0);
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
        cylWheel.set(ControlMode.PercentOutput, 0.0);
    }

    public void change_LimiterUP(){
        LIMITER=0.75;
    }

    public void change_LimiterDOWN(){
        LIMITER=0.6;
    }
}

