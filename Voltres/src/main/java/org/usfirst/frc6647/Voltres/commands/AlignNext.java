/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import org.usfirst.frc6647.Voltres.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlignNext extends Command {

	private boolean toLeft;
	private double yaw;

	public AlignNext(boolean toLeft) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.toLeft = toLeft;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if(!Robot.robotDrive.getPIDController().isEnabled())
			end();

		yaw = Robot.robotDrive.getPIDController().getSetpoint();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(toLeft) {
			if(yaw == 0) {
				Robot.robotDrive.setSetpoint(28.77);
				Robot.robotDrive.negativeOutput = true;
			}
			else if(yaw == 28.77)
				Robot.robotDrive.setSetpoint(0);
			else if(yaw == 90)
				Robot.robotDrive.setSetpoint(28.77);
			else if(yaw == 151.23)
				Robot.robotDrive.setSetpoint(90);
			else if(yaw == 180)
				Robot.robotDrive.setSetpoint(151.23);
		} else {
			if(yaw == 0)
				Robot.robotDrive.setSetpoint(28.77);
			else if(yaw == 28.77)
				Robot.robotDrive.setSetpoint(90);
			else if(yaw == 90)
				Robot.robotDrive.setSetpoint(151.23);
			else if(yaw == 151.23)
				Robot.robotDrive.setSetpoint(180);
			else if(yaw == 180) {
				Robot.robotDrive.setSetpoint(151.23);
				Robot.robotDrive.negativeOutput = true;
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		if(Robot.robotDrive.negativeOutput)
			Robot.robotDrive.negativeOutput = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
