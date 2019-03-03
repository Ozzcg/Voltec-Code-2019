/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.commands;

import org.usfirst.frc6647.Voltres.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionAlign extends Command {

  private int setpoint = 160;
  private double velRotation = 0.43;
  private double velH = 0.35;
  
  public VisionAlign() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveWPID);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
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
        // Is at the left
        if(Robot.vision.rightPacket.X < 160 + Robot.vision.toleranceRightTarget)
        {
          Robot.driveWPID.Rotate_Robot(false, velRotation);
        }
        else if(Robot.vision.rightPacket.X > 320 - Robot.vision.toleranceRightTarget)
        {
          Robot.driveWPID.Rotate_Robot(true, velRotation);
        }
      }
      else{
        // Is at the left
        if(Robot.vision.leftPacket.X < Robot.vision.toleranceLeftTarget)
        {
          Robot.driveWPID.Rotate_Robot(false, velRotation);
        }
        else if(Robot.vision.leftPacket.X > 160 - Robot.vision.toleranceLeftTarget)
        {
          Robot.driveWPID.Rotate_Robot(true, velRotation);
        }
      }

      if(Robot.vision.rightPacket.Width > Robot.vision.leftPacket.Width)
      {
        Robot.driveWPID.Drift(velH);
      }
      else
      {
        Robot.driveWPID.Drift(-velH);
      }

/*
      // Oriented to the right of the target
      if(Robot.vision.leftPacket - setpoint > tolerance)
      {
        Robot.driveWPID.Rotate_Robot(true, velRotation);
        Robot.driveWPID.Drift(velH);
      }
      // Oriented to the left of the target
      else if(Robot.vision.mainPacket.X - setpoint < -tolerance)
      {
        Robot.driveWPID.Rotate_Robot(false, velRotation);
        Robot.driveWPID.Drift(-velH);
      }
      */
    }
    else{
      Robot.driveWPID.Rotate_Stop();
      Robot.driveWPID.Drift_Stop();
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    
    return Robot.vision.isAlignedH() && Robot.vision.isAlignedRotation();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveWPID.Rotate_Stop();
    Robot.driveWPID.Drift_Stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
