// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.RobotMap;

import org.usfirst.frc6647.Voltres.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class TilTake extends Subsystem {

    private static int direction1 = 1;
    private static int direction2 = -1;
    private static double tilt_up_speed = 0.1;
    private static double tilt_down_speed = 0.1;
    private static WPI_VictorSPX tilTake;


    public TilTake() {
        tilTake = RobotMap.tilTake;
    }

    @Override
    public void initDefaultCommand() {
        Stop_Tilt();
    }

    public void Tilt_Up(){
        tilTake.set(ControlMode.PercentOutput, tilt_up_speed*direction1);
    }

    public void Tilt_Down(){
        tilTake.set(ControlMode.PercentOutput, tilt_down_speed*direction2);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void Stop_Tilt(){
        tilTake.set(ControlMode.PercentOutput, 0.0);
    }

}
