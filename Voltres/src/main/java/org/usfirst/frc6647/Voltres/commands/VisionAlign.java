/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class VisionAlign extends Command {

	private double targetAngle;
	private WPI_TalonSRX hWheel;
	private double kP = 1.2;

	public VisionAlign() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.robotDrive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		hWheel = RobotMap.hWheel;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.vision.tapeSeen()) {
			targetAngle = Robot.vision.tapeYaw();
		} else {
			targetAngle = 0;
		}

		double output = limitOutput(-kP * targetAngle, 0.3);

		hWheel.set(ControlMode.PercentOutput, output);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(targetAngle)<3;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

	public double limitOutput(double number, double maxOutput) {
		if(number > 1.0) {
			number = 1.0;
		}
		if(number < -1.0) {
			number = -1.0;
		}

		if(number > maxOutput) {
			return maxOutput;
		}
		if(number < -maxOutput) {
			return -maxOutput;
		}

		return number;
	}
}
