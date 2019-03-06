/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import javax.lang.model.util.ElementScanner6;

import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.subsystems.Robot_TilTake;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAlign extends Command {

  private double velRotation = 0.4;
  private double velH = 0.4;

  private double velChassis = 0.40;
  
  public VisionAlign() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	Robot.manualModeChassis = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	
	

	
	if(Robot.vision.pixy1.isReading)
	{
		SmartDashboard.putString("OUTDATA", "ABS(L-R)= <" + (Robot.vision.leftPacket.Width - Robot.vision.rightPacket.Width) + ">");

		// Last updated was right. We only read one value at a time
		if(Robot.vision.lastWasRight)
		{
			if(Robot.vision.isAlignedRight())
			{
				SmartDashboard.putBoolean("AlignedHeightRight", false);

				if(Robot.vision.rightPacket.Height < Robot.vision.setpointHeight - Robot.vision.toleranceHeight)
				{
					Robot.driveWPID.moveChassis(velChassis, 0);
				}
				else if(Robot.vision.rightPacket.Height > Robot.vision.setpointHeight +  Robot.vision.toleranceHeight)
				{
					Robot.driveWPID.moveChassis(-velChassis, 0);
				}
				else {
					SmartDashboard.putBoolean("AlignedHeightRight", true);
					//Robot.driveWPID.moveChassis(0, 0);
				}
			}
			else
			{
				SmartDashboard.putBoolean("AlignedRotationRight", false);
				// Is on the left side of setpoint
				if(Robot.vision.rightPacket.X < Robot.vision.setpointXRight - Robot.vision.toleranceX)
				{
					Robot.driveWPID.Rotate_Robot(false, velRotation);
					//Robot.driveWPID.Drift(-velH);
				}

				// Is on the right side of setpoint
				else if(Robot.vision.rightPacket.X > Robot.vision.setpointXRight + Robot.vision.toleranceX)
				{
					Robot.driveWPID.Rotate_Robot(true, velRotation);
					//Robot.driveWPID.Drift(velH);
				}
				else{
					SmartDashboard.putBoolean("AlignedRotationRight", true);
					//Robot.driveWPID.Rotate_Robot(true, 0);
				}
			}
		}
		else{
			if(Robot.vision.isAlignedLeft())
			{
				SmartDashboard.putBoolean("AlignedHeightLeft", false);
				
				if(Robot.vision.leftPacket.Height < Robot.vision.setpointHeight - Robot.vision.toleranceHeight)
				{
					Robot.driveWPID.moveChassis(velChassis, 0);
				}
				else if(Robot.vision.leftPacket.Height > Robot.vision.setpointHeight + Robot.vision.toleranceHeight)
				{
					Robot.driveWPID.moveChassis(-velChassis, 0);
				}
				else {
					SmartDashboard.putBoolean("AlignedHeightLeft", true);
					//Robot.driveWPID.moveChassis(0, 0);
				}
			}
			else{
				SmartDashboard.putBoolean("AlignedRotationLeft", false);

				// Is on the left side of setpoint
				if(Robot.vision.leftPacket.X < Robot.vision.setpointXLeft - Robot.vision.toleranceX)
				{
					Robot.driveWPID.Rotate_Robot(false, velRotation);
					//Robot.driveWPID.Drift(-velH);
				}

				// Is on the right side of setpoint
				else if(Robot.vision.leftPacket.X > Robot.vision.setpointXLeft + Robot.vision.toleranceX)
				{
					Robot.driveWPID.Rotate_Robot(true, velRotation);
					//Robot.driveWPID.Drift(velH);
				}
				else{
					SmartDashboard.putBoolean("AlignedRotationLeft", true);
					//Robot.driveWPID.Rotate_Robot(true, 0);
				}
			}

			
		}

		// HWheel
		
		if(((Robot.vision.leftPacket.X + Robot.vision.rightPacket.X) / 2 ) < 155)
		{
			Robot.driveWPID.Drift(velH);
		}
		else if(((Robot.vision.leftPacket.X + Robot.vision.rightPacket.X) / 2 ) > 165)
		{
			Robot.driveWPID.Drift(-velH);
		}
		else{
			Robot.driveWPID.Drift(0);
		}
		

		/*
		if(Robot.vision.onWidth())
		{
			//Robot.driveWPID.Drift(0);
		}
		else{

			// Only align if both have been initialized
			if(Math.abs(Robot.vision.rightPacket.Width - Robot.vision.leftPacket.Width) <= 10)
			{
				if(Robot.vision.rightPacket.Width > Robot.vision.leftPacket.Width)
				{
					Robot.driveWPID.Drift(velH);
				}
				else if(Robot.vision.rightPacket.Width < Robot.vision.leftPacket.Width)
				{
					Robot.driveWPID.Drift(-velH);
				}
				else{
					Robot.driveWPID.Drift(0);
				}
			}
			
		}
		*/

		/*
		
		if(Robot.vision.onHeight() && Robot.vision.isAlignedLeft() && Robot.vision.isAlignedRight())
		{
			Robot.driveWPID.Rotate_Stop();
	  		Robot.driveWPID.Drift_Stop();
		}
		*/
	}
	else{
	  //Robot.driveWPID.Rotate_Stop();
	  //Robot.driveWPID.Drift_Stop();
	}

	
	
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
	/*
	if(Robot.vision.lastWasRight)
	{
		return Robot.vision.onHeight() && Robot.vision.onWidth() && Robot.vision.isAlignedRight();
	}
	else{
		return Robot.vision.onHeight() && Robot.vision.onWidth() && Robot.vision.isAlignedLeft();
	}
	*/
	return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	//Robot.driveWPID.Rotate_Stop();
	//Robot.driveWPID.Drift_Stop();
	Robot.manualModeChassis = true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
	end();
  }
}
