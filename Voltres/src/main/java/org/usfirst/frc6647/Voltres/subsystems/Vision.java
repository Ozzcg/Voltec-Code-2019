/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Vision subsystem.
 */
public class Vision extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private NetworkTableEntry tapeDetected, tapeYaw;
	NetworkTableInstance instance;
	NetworkTable chickenVision;

	public Vision() {
		instance = NetworkTableInstance.getDefault();
		chickenVision = instance.getTable("ChickenVision");

		tapeDetected = chickenVision.getEntry("tapeDetected");
		tapeYaw = chickenVision.getEntry("tapeYaw");
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public boolean tapeSeen() {
		return tapeDetected.getBoolean(false);
	}

	public double tapeYaw() {
		return tapeYaw.getDouble(0);
	}
}