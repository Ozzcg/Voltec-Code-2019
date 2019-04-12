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
 * Subsystem for the hWheel, separate from Robot_Drive.
 */
public class Robot_hWheel extends Subsystem {

	private static WPI_TalonSRX hWheel;

	/**
	 * Constructor for the subsystem.
	 */
	public Robot_hWheel() {
        hWheel = RobotMap.hWheel;
	}

	@Override
	public void initDefaultCommand() {
	}

	/**
	 * Move the hWheel in PercentOutput.
	 * @param speed
	 */
	public void moveHWheel(double speed) {
		hWheel.set(ControlMode.PercentOutput, speed);
	}

	/**
	 * Halt any movement of the HWheel.
	 */
	public void stopHWheel() {
		hWheel.set(ControlMode.PercentOutput, 0);
	}
}
