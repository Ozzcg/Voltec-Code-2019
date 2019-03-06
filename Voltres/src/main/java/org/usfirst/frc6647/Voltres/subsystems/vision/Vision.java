package org.usfirst.frc6647.Voltres.subsystems.vision;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;
import java.util.HashMap;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Vision extends Subsystem {


	// These values are the default if you instantiate a PixySPI without arguments.
	// To create multiple PixySPI objects and thus use multiple Pixy cameras via SPI
	// Copy the items below, change variable names as needed and especially change
	// the SPI port used eg; Port.kOnboardCS[0-3] or Port.
	
	public int setpointWidth = 17;
	public int toleranceWidth = 5;

	public int setpointHeight = 30;
	public int toleranceHeight = 5;

	public int setpointXRight = 182;

	public int setpointXLeft = 114;

	public int toleranceX = 6;

	

	public PixySPI pixy1;
	Port port = Port.kOnboardCS0;
	String print;
	public HashMap<Integer, ArrayList<PixyPacket>> packets = new HashMap<Integer, ArrayList<PixyPacket>>();

	public PixyPacket leftPacket, rightPacket;

	public boolean lastWasRight = true;

	public Vision(){
		// Open a pipeline to a Pixy camera.
		pixy1 = new PixySPI(new SPI(port), packets, new PixyException(print));

		// Initialize values at max and minimum values (0,320) 
		// with height & width = 1
		leftPacket = new PixyPacket();
		rightPacket = new PixyPacket();
		leftPacket.X = 0;
		rightPacket.X = 320;
		leftPacket.Height = rightPacket.Height = 1;
		leftPacket.Width = rightPacket.Width = 1;
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void testPixy1(){
		SmartDashboard.putBoolean("IsReading", pixy1.isReading);

		int ret = -1;
		// Get the packets from the pixy.
		try {
			ret = pixy1.readPackets();
		} catch (PixyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SmartDashboard.putNumber("Pixy Vision: packets size: ", packets.size());

		for(int i = 1; i <= PixySPI.PIXY_SIG_COUNT ; i++) {
			SmartDashboard.putString("Pixy Vision: Signature " + Integer.toString(i) + ": ", Integer.toString(i));

			SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(i) + ": size: ", packets.get(i).size());
			
			// Loop through the packets for this signature.
			for(int j=0; j < packets.get(i).size(); j++) {

				PixyPacket tmpPacket = packets.get(i).get(j);
				
				if(tmpPacket.X < 160)
				{
					leftPacket = packets.get(i).get(j);
					lastWasRight = false;
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " LEFT : X: ", packets.get(i).get(j).X);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " LEFT : Y: ", packets.get(i).get(j).Y);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " LEFT : Width: ", packets.get(i).get(j).Width);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " LEFT : Height: ", packets.get(i).get(j).Height);
				}
				else{
					rightPacket = packets.get(i).get(j);
					lastWasRight = true;
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " RIGHT : X: ", packets.get(i).get(j).X);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " RIGHT : Y: ", packets.get(i).get(j).Y);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " RIGHT : Width: ", packets.get(i).get(j).Width);
					SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + " RIGHT : Height: ", packets.get(i).get(j).Height);
				}
			}

			SmartDashboard.putBoolean("LastWasRight", lastWasRight);
		}
		
	}
	
	// 25 - 35
	public boolean onHeight()
	{
		return (leftPacket.Height >= setpointHeight - toleranceHeight && leftPacket.Height <= setpointHeight + toleranceHeight);
	}

	// 173
	// 190
	public boolean isAlignedRight()
	{
		return (rightPacket.X >= setpointXRight - toleranceX && rightPacket.X <= setpointXRight + toleranceX);
	}

	// 105 
	// 122
	public boolean isAlignedLeft()
	{
		return (leftPacket.X >= setpointXLeft - toleranceX && leftPacket.X <= setpointXLeft + toleranceX);
	}

	// 12 - 22
	public boolean onWidth()
	{
		return (leftPacket.Width >= setpointWidth - toleranceWidth && leftPacket.Width <= setpointWidth + toleranceWidth) &&  (rightPacket.Width >= setpointWidth - toleranceWidth && rightPacket.Width <= setpointWidth + toleranceWidth);
	}


}
