/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.Voltres.subsystems;



import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    private boolean tapeSeen;
    private NetworkTableEntry tapeDetected, tapeYaw;
    NetworkTableInstance instance;
    NetworkTable chickenVision;
    private double targetAngle;
    private static double offset = -4;
    public Vision() {
        instance = NetworkTableInstance.getDefault();
        chickenVision = instance.getTable("ChickenVision");
        tapeDetected = chickenVision.getEntry("tapeDetected");
        tapeYaw = chickenVision.getEntry("tapeYaw");
    
        targetAngle = 0;
        run();
        
    }
    public void run(){
        tapeSeen = tapeDetected.getBoolean(false);
        SmartDashboard.putNumber("targetAngle", targetAngle);
        SmartDashboard.putBoolean("tapeseen", tapeSeen);
        if(tapeSeen)
            targetAngle = tapeYaw.getDouble(0);

    }
    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }
    @Override
    public void periodic() {
        
    }
    public double limitOutput() {
        if(Math.abs(targetAngle-offset)>3 && tapeSeen){
            if (targetAngle > offset){
                SmartDashboard.putString("Side", "left");
                return -0.5*targetAngle*.07;
            }else {
                SmartDashboard.putString("Side", "Right");
                return -0.5*targetAngle*.07;
            }
        }else
            return 0;
    }
}
