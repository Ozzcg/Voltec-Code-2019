/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import org.usfirst.frc6647.Voltres.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to move hWheel left or right.
 */
public class Slide extends Command {

	private boolean toLeft;
	private double analogLT, analogRT;

	/**
	 * Constructor for the command, receives whether the Robot
	 * will slide left or right.
	 * @param toLeft
	 */
	public Slide(boolean toLeft) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.toLeft = toLeft;
		requires(Robot.hWheel);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		analogLT = (Robot.oi.joystick1.getRawAxis(3) + 1) / 2;
		analogRT = (Robot.oi.joystick1.getRawAxis(4) + 1) / 2;

		if(toLeft)
			Robot.hWheel.moveHWheel(analogLT * 0.7);
		else
			Robot.hWheel.moveHWheel(-analogRT * 0.7);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.hWheel.stopHWheel();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
