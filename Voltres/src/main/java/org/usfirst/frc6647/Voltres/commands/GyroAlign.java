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

import edu.wpi.first.wpilibj.command.Command;

public class GyroAlign extends Command {

	private AHRS ahrs;
	private double angle;

	public GyroAlign(double angle) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.angle = angle;
		ahrs = RobotMap.NAVX;

		requires(Robot.robotDrive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
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
		return Math.abs(angle - (ahrs.getAngle() % 360)) <= 5.00;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.robotDrive.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
