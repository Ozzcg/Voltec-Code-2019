/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Add your docs here.
 */
public class Autonomous_Commands extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public static int ret;
  public Autonomous_Commands() {
    // Intert a subsystem name and PID values here
    super("SubsystemName", RobotMap.liftP, RobotMap.liftI, RobotMap.liftD);
    // Use these to get going:

    setOutputRange(-1, 1);
    setAbsoluteTolerance(20);
    getPIDController().setContinuous();
  }
  public void setPoint(int position){
    setSetpoint(position); //- Sets where the PID controller should move the system
  }
  public void setPIDValues(){
    getPIDController().setPID(RobotMap.liftP, RobotMap.liftI, RobotMap.liftD);
  }
  public void stop(){
    RobotMap.liftMain.stopMotor();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    ret = RobotMap.liftEncoder.get();
    return ret;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    RobotMap.liftMain.set(output);
  }
}
