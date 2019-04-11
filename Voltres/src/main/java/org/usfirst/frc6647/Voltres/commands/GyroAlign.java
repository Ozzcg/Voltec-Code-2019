/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;
import org.usfirst.frc6647.Voltres.subsystems.Robot_Drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroAlign extends Command {

	private double angle;

	public GyroAlign(double angle) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.angle = angle;

		requires(Robot.robotDrive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		SmartDashboard.putBoolean("Gyro", true);
		checkAngle();
		Robot.robotDrive.setSetpoint(angle);
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
		return Math.abs(angle - RobotMap.NAVX.getAngle() % 360) <= 5.00;
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

	public void checkAngle() {
		if(RobotMap.NAVX.getAngle() % 360 < 0) {
			if(Robot.robotDrive.toLeft) {
				Robot.robotDrive.toLeft = false;
			} else {
				Robot.robotDrive.toLeft = true;
			}
		} else {
			Robot.robotDrive.toLeft = true;
		}
	}
}
