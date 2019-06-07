/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class LiftWithPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */

  private static int direction1 = 1;
  private static int direction2 = -1;
  private static double lift_up_speed = 0.8;
  private static double lift_down_speed = 0.6;
  private static Encoder lift_Encoder;
  private static DigitalInput downlimit;

  private static WPI_VictorSPX liftMain;

      /*
    private static WPI_VictorSPX liftMain;
    */


  public static int ret;
  public LiftWithPID() {
    
    // Intert a subsystem name and PID values here
    super("SubsystemName", RobotMap.liftP, RobotMap.liftI, RobotMap.liftD);
    // Use these to get going:
    setInputRange(-3600000,  360000);
    setOutputRange(-0.8, 0.8);
    setAbsoluteTolerance(200);
    getPIDController().setContinuous(true);

    liftMain = RobotMap.liftMain;
        lift_Encoder = RobotMap.liftEncoder;
        downlimit = RobotMap.lowLimitLift;
  }
  public void setPoint(int position){
    setSetpoint(position); //- Sets where the PID controller should move the system
  }
  public void setPIDValues(){
    getPIDController().setPID(RobotMap.liftP, RobotMap.liftI, RobotMap.liftD);
  }
  public int getRet(){
    return ret;
  }
  public void stop(){
    liftMain.stopMotor();
  }

  public void Lift_Up(){
    liftMain.set(ControlMode.PercentOutput, lift_up_speed*direction1);
}

public void Lift_Down(){
    if (!downlimit.get()){
      liftMain.set(ControlMode.PercentOutput, 0);
    }else{
      liftMain.set(ControlMode.PercentOutput, 0.3*direction2);
    }
}

@Override
public void periodic() {
    // Put code here to be run every loop
    SmartDashboard.putNumber("Lift Encoder Value", lift_Encoder.get());
    SmartDashboard.putBoolean("Encoder Limit Down", downlimit.get());
    if(downlimit.get() !=true) lift_Encoder.reset();
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
    ret = lift_Encoder.get();
    return ret;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    liftMain.set(output);
  }

  public void Stop_Lift(){
    liftMain.set(ControlMode.PercentOutput, 0.0);
   }
}