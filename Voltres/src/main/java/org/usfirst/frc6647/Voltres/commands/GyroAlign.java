/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroAlign extends Command {

	private double angle;

	public GyroAlign() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.robotDrive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		SmartDashboard.putBoolean("Gyro", true);
		//Robot.robotDrive.setSetpoint(angle);
		angle = Math.abs(RobotMap.NAVX.getYaw());
		if(Math.abs(angle) < 30.615) {
			Robot.robotDrive.setSetpoint(0);
		} else if(30.615 <= angle && angle < 75.615) {
			Robot.robotDrive.setSetpoint(61.23);
		} else if(75.615 <= angle && angle < 104.385) {
			Robot.robotDrive.setSetpoint(90);
		} else if(104.385 <= angle && angle < 149.385) {
			Robot.robotDrive.setSetpoint(118.77);
		} else if(Math.abs(angle) >= 149.385) {
			Robot.robotDrive.setSetpoint(180);
		}/* else if(-30.615 >= angle && angle > -75.615) {
			Robot.robotDrive.setSetpoint(-61.23);
		} else if(-75.615 >= angle && angle > -104.385) {
			Robot.robotDrive.setSetpoint(-90);
		} else if(-104.385 >= angle && angle > -149.385) {
			Robot.robotDrive.setSetpoint(-118.77);
		}*/

		SmartDashboard.putNumber("targetGyro", Robot.robotDrive.getPIDController().getSetpoint());
		
		Robot.robotDrive.enable();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.robotDrive.setPIDValues();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.robotDrive.getPIDController().onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.robotDrive.disable();
		SmartDashboard.putBoolean("Gyro", false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
