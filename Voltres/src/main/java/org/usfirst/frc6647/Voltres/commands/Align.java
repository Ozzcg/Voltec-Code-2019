/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Align extends CommandGroup {
	/**
	 * GyroAlign() and VisionAlign().
	 */
	public Align() {

		double angle = RobotMap.NAVX.getAngle() % 360;

		// oof.wav
		if(angle > 0 || angle < 14.375) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(0));
		} else if(angle >= 14.375 || angle < 28.75) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(28.75));
		} else if(angle >= 28.75 || angle < 59.375) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(28.75));
		} else if(angle >= 59.375 || angle < 90) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(90));
		} else if(angle >= 90 || angle < 120.625) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(90));
		} else if(angle >= 120.625 || angle < 151.25) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(151.25));
		} else if(angle >= 151.25 || angle < 180) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(151.25));
		} else if(angle >= 180 || angle < 208.75) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(208.75));
		} else if(angle >= 208.75 || angle < 239.375) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(208.75));
		} else if(angle >= 239.275 || angle < 270) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(270));
		} else if(angle >= 270 || angle < 300.625) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(270));
		} else if(angle >= 300.625 || angle < 331.25) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(331.25));
		} else if(angle >= 331.25 || angle < 345.625) {
			Robot.robotDrive.toLeft = true;
			addSequential(new GyroAlign(331.25));
		} else if(angle >= 345.625 || angle < 360) {
			Robot.robotDrive.toLeft = false;
			addSequential(new GyroAlign(0));
		}

		addSequential(new VisionAlign());

		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
