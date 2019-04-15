/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for Robot climbing mechanism.
 */
public class Robot_Climb extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private int up = 1, down = -1;
	private double speed_slow = 0.4, speed_fast = 0.7;
	private WPI_TalonSRX frontTalon, backTalons, wheels;

	public Robot_Climb() {
		frontTalon = RobotMap.climbFront;
		backTalons = RobotMap.climbBackLeft;
		wheels = RobotMap.climbWheels;
	}

	/**
	 * Raise front talon (fast).
	 */
	public void frontHoistSchnell() {
		frontTalon.set(ControlMode.PercentOutput, speed_fast * up);
	}

	/**
	 * Raise front talon (slow).
	 */
	public void frontHoistLangsam() {
		frontTalon.set(ControlMode.PercentOutput, speed_slow * up);
	}

	/**
	 * Lower front talon (fast).
	 */
	public void frontSinkSchnell() {
		frontTalon.set(ControlMode.PercentOutput, speed_fast * down);
	}

	/**
	 * Lower front talon (slow).
	 */
	public void frontSinkLangsam() {
		frontTalon.set(ControlMode.PercentOutput, speed_slow * down);
	}

	/**
	 * Raise back talons (fast).
	 */
	public void backHoistSchnell() {
		backTalons.set(ControlMode.PercentOutput, speed_fast * up);
	}

	/**
	 * Raise back talons (slow).
	 */
	public void backHoistLangsam() {
		backTalons.set(ControlMode.PercentOutput, speed_slow * up);
	}

	/**
	 * Lower back talons (fast).
	 */
	public void backSinkSchnell() {
		backTalons.set(ControlMode.PercentOutput, speed_fast * down);
	}

	/**
	 * Lower back talons (slow).
	 */
	public void backSinkLangsam() {
		backTalons.set(ControlMode.PercentOutput, speed_slow * down);
	}

	/**
	 * Move wheels in percent output.
	 * @param speed
	 */
	public void moveWheels(double speed) {
		wheels.set(ControlMode.PercentOutput, speed);
	}

	/**
	 * Cease movement of wheels.
	 */
	public void stopWheels() {
		wheels.set(ControlMode.PercentOutput, 0.0);
	}

	/**
	 * Cease talon movement.
	 */
	public void stopClimb() {
		frontTalon.set(ControlMode.PercentOutput, 0.0);
		backTalons.set(ControlMode.PercentOutput, 0.0);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
