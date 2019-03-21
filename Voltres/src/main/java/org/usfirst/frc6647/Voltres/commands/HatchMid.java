// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6647.Voltres.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6647.Voltres.Robot;
import org.usfirst.frc6647.Voltres.RobotMap;

/**
 *
 */
public class HatchMid extends Command {


    public HatchMid() {
        requires(Robot.liftWithPID);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.liftWithPID.setSetpoint(RobotMap.ballLevel2);

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.liftWithPID.setPIDValues();
        Robot.liftWithPID.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;//Math.abs(RobotMap.hatchLv2-Robot.liftWithPID.getRet())<100;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.liftWithPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
