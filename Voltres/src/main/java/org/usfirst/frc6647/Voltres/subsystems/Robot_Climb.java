/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Subsystem for Robot climbing mechanism.
 */
public class Robot_Climb extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private int up = 1, down = -1;
	private double speed_slow = 0.4, speed_fast = 0.7;
	private WPI_VictorSPX frontTalon, backTalons, wheels;

	public Robot_Climb() {
		frontTalon = RobotMap.climbFront;
		backTalons = RobotMap.climbBackLeft;
		wheels = RobotMap.climbWheels;
	}


////////////Aqui empiezan las funciones
	
	public void frontHabClimb() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("FrontClimbSpeed", -0.8));
	}

	public void frontHabLetSlide() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("FrontSlideSpeed", -0.6));
	}

	public void frontHabReturn() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("FrontReturn", 0.6));
	}

	public void frontHabHold() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("FrontHold", -0.8));
	}

	public void rearHabClimb() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BackClimbSpeed", -0.85));
	}

	public void rearHabLetSlide() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BackSlideSpeed", -0.6));
	}

	public void rearHabReturn() {
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BackReturn", 0.6));
	}

	public void rearHabHold(){
		//cambiar
		frontTalon.set(ControlMode.PercentOutput, SmartDashboard.getNumber("BackHold", -0.75));
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
		backTalons.set(ControlMode.PercentOutput, 0.0);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
