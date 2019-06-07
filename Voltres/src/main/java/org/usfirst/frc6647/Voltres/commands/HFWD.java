
package org.usfirst.frc6647.Voltres.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6647.Voltres.Robot;

public class HFWD extends Command {
  public HFWD() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.intake.H_Out();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.oi.sButton10.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intake.H_Stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}