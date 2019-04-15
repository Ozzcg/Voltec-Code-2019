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

/*
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
*/
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot_Drive extends PIDSubsystem {

    private static final double TOLERANCE = 0.15; // tolerancia del joystick(quita el error)
    private static double LIMITER = 0.75; // Por si quieren limitar la velocidad del drive
    private static double padLIMITER = 0.9;
    private static int direction = 1; // para invertir los ejes si necesario
    private static WPI_TalonSRX lefTalon;
    private static WPI_TalonSRX righTalon;

    public double acceleration;
    public double accelerationMultiplier = 0.0;
    public boolean negativeOutput = false;

    // private static DifferentialDrive diffDrive;

    // private static double statepiston=1;

    public Robot_Drive() {
        super("Robot_Drive", RobotMap.gyroP, RobotMap.gyroI, RobotMap.gyroD);

        lefTalon = RobotMap.frontLeft;
        righTalon = RobotMap.frontRight;

        // diffDrive = new DifferentialDrive( lefTalon, righTalon);
        // diffDrive.setRightSideInverted(false);
        // diffDrive.setExpiration(0.02);
        // diffDrive.setSafetyEnabled(false);

        setInputRange(-180, 180);
        setOutputRange(-0.70, 0.70);
        setAbsoluteTolerance(1);
        getPIDController().setContinuous(true);

    }

    @Override
    public void initDefaultCommand() {
        Main_Drive();
    }

    public void Main_Drive() {
        // For Differential Drive

        /*
         * double
         * LeftStickY=mapDoubleT(joystick.getRawAxis(0),TOLERANCE,1,0,1)*direction*-1,
         * LeftStickX=mapDoubleT(joystick.getRawAxis(1),TOLERANCE,1,0,1)*direction,
         * RightStickX=mapDoubleT(joystick.getRawAxis(2), TOLERANCE, 1, 0, 1);
         * 
         * diffDrive.arcadeDrive(LeftStickY*LIMITER, LeftStickX*LIMITER*0.8);
         * 
         * hWheel.set(ControlMode.PercentOutput, RightStickX);
         */

        //////////////////////////////////////

        // For Tank Drive/////////////

        double LeftStickY = mapDoubleT(Robot.oi.joystick1.getRawAxis(1), TOLERANCE, 1, 0, 1) * direction,
                RightStickY = mapDoubleT(Robot.oi.joystick1.getRawAxis(5), TOLERANCE, 1, 0, 1) * direction;

        if (Robot.oi.joystick1.getPOV() == -1 && SmartDashboard.getBoolean("Gyro", false) == false) {
            lefTalon.set(ControlMode.PercentOutput, LeftStickY * LIMITER);
            righTalon.set(ControlMode.PercentOutput, RightStickY * LIMITER);
        }

        /////////////////////////////////////

        SmartDashboard.putNumber("EncoderL chassis", lefTalon.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("EncoderR chassis", righTalon.getSelectedSensorPosition(0));
        // SmartDashboard.putNumber("LT Value", analogLT);
        // SmartDashboard.putNumber("RT Value", analogRT);
    }

    public double getSensorL() {
        return lefTalon.getSelectedSensorPosition(0);
    }

    public double getSensorR() {
        return righTalon.getSelectedSensorPosition(0);
    }

    private double mapDoubleT(double x, double in_min, double in_max, double out_min, double out_max) {
        if (Math.abs(x) < TOLERANCE) {
            return 0;
        }
        if (x < 0) {
            return map(x, -in_min, -in_max, -out_min, -out_max);
        }
        return map(x, in_min, in_max, out_min, out_max);
    }

    private double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        SmartDashboard.putNumber("EncoderL chassis", lefTalon.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("EncoderR chassis", righTalon.getSelectedSensorPosition(0));
    }

    public void Stop_Drive() {
        lefTalon.set(ControlMode.PercentOutput, 0.0);
        righTalon.set(ControlMode.PercentOutput, 0.0);
    }

    public void change_LimiterUP() {
        LIMITER = 0.75;
        padLIMITER = 0.9;
    }

    public void change_LimiterDOWN() {
        LIMITER = 0.6;
        padLIMITER = 0.6;
    }

    @Override
    protected double returnPIDInput() {
        SmartDashboard.putNumber("PIDInput", RobotMap.NAVX.getYaw());
        return Math.abs(RobotMap.NAVX.getYaw());
    }

    @Override
    protected void usePIDOutput(double output) {
        if (RobotMap.NAVX.getYaw() > 0 && !negativeOutput)
            output *= -1;

        SmartDashboard.putNumber("PIDOutput", output);

        int angle = Robot.oi.joystick1.getPOV();
        if (angle == 0) {
            lefTalon.set(ControlMode.PercentOutput, (-0.5 - (acceleration * accelerationMultiplier)) * padLIMITER + output);
            righTalon.set(ControlMode.PercentOutput, (-0.5 - (acceleration * accelerationMultiplier)) * padLIMITER - output);
        } else if (angle == 180) {
            lefTalon.set(ControlMode.PercentOutput, (0.5 + (acceleration * accelerationMultiplier)) * padLIMITER + output);
            righTalon.set(ControlMode.PercentOutput, (0.5 + (acceleration * accelerationMultiplier)) * padLIMITER - output);
        } else {
            lefTalon.set(ControlMode.PercentOutput, output);
            righTalon.set(ControlMode.PercentOutput, -output);
        }

    }

    public void setPIDValues() {
        getPIDController().setPID(RobotMap.gyroP, RobotMap.gyroI, RobotMap.gyroD);
    }
}
