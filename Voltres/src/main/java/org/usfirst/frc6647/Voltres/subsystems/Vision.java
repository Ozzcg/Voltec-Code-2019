/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Vision extends PIDSubsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private boolean tapeSeen;
	private NetworkTableEntry tapeDetected, tapeYaw;
	NetworkTableInstance instance;
	NetworkTable chickenVision;
	private double currentYaw;
	private double offset;

	public Vision() {
		super("Vision", RobotMap.visionP, RobotMap.visionI, RobotMap.visionD);

		instance = NetworkTableInstance.getDefault();
		chickenVision = instance.getTable("ChickenVision");
		tapeDetected = chickenVision.getEntry("tapeDetected");
		tapeYaw = chickenVision.getEntry("tapeYaw");

		run();

		setInputRange(-100, 100);
		setOutputRange(-1.0, 1.0);
		setSetpoint(offset);
		setAbsoluteTolerance(0);
		getPIDController().setContinuous(true);
	}

	public void run() {
		offset = RobotMap.visionOffset;
		getPIDController().setPID(RobotMap.visionP, RobotMap.visionI, RobotMap.visionD);

		tapeSeen = tapeDetected.getBoolean(false);
		
		if (tapeSeen)
			currentYaw = tapeYaw.getDouble(offset);
		else
			currentYaw = offset;

		SmartDashboard.putNumber("currentYaw", currentYaw);
		SmartDashboard.putBoolean("tapeSeen", tapeSeen);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	protected double returnPIDInput() {
		return currentYaw;
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.hWheel.moveHWheel(output);
	}

	public boolean tapeSeen() {
		return tapeSeen;
	}
}
