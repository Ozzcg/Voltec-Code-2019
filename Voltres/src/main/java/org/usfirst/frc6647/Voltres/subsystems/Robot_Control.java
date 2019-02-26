package org.usfirst.frc6647.Voltres.subsystems;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class Robot_Control extends Subsystem {

    public Robot_Control() {
        
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor compressor = RobotMap.Compressor;


    public void initDefaultCommand() {

    }
    
    public void turnCompressorOn() {
        compressor.setClosedLoopControl(true);
    }
    
    public void turnCompressorOff() {
    	compressor.setClosedLoopControl(false);
    }

    
    
}