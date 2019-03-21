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

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAlign extends Command {

	public NetworkTableEntry tapeDetected, tapeYaw;

	private double target;
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

		try {
			tapeDetected = SmartDashboard.getEntry("tapeDetected");
			tapeYaw = SmartDashboard.getEntry("tapeYaw");
		} catch(Exception e) {
			e.printStackTrace();
			end();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		try {
			if(tapeDetected.getBoolean(false)) {
				target = tapeYaw.getDouble(0);
			} else {
				target = 0;
			}
		} catch(Exception e) {
			e.printStackTrace();
			end();
		}

		double output = limitOutput(-kP * target, 0.35);

		hWheel.set(ControlMode.PercentOutput, output);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return tapeYaw.getDouble(0) == -3; //Ajustar valor
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		hWheel.set(ControlMode.PercentOutput, 0);
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
