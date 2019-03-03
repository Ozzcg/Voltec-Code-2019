package org.usfirst.frc6647.Voltres.subsystems.vision;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.usfirst.frc6647.Voltres.RobotMap;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Vision extends Subsystem {

	// These values are the default if you instantiate a PixySPI without arguments.
	// To create multiple PixySPI objects and thus use multiple Pixy cameras via SPI
	// Copy the items below, change variable names as needed and especially change
	// the SPI port used eg; Port.kOnboardCS[0-3] or Port.kMXP
	public PixySPI pixy1;
	Port port = Port.kOnboardCS0;
	String print;
	public HashMap<Integer, ArrayList<PixyPacket>> packets = new HashMap<Integer, ArrayList<PixyPacket>>();

	public PixyPacket leftPacket;
	public PixyPacket rightPacket;

	public boolean twoObjects;

	public Vision(){
		// Open a pipeline to a Pixy camera.
		pixy1 = new PixySPI(new SPI(port), packets, new PixyException(print));
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void testPixy1(){
		int ret = -1;
		// Get the packets from the pixy.
		try {
			ret = pixy1.readPackets();
		} catch (PixyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SmartDashboard.putNumber("Pixy Vision: packets size: ", packets.size());
		SmartDashboard.putBoolean("Reading: ", pixy1.isReading);

		for(int i = 1; i <= PixySPI.PIXY_SIG_COUNT ; i++) {
			SmartDashboard.putString("Pixy Vision: Signature: ", Integer.toString(i));

			SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(i) + ": size: ", packets.get(i).size());

			SmartDashboard.putNumber("Packet size: ", packets.get(i).size());

			if(packets.get(i).size() >= 2) {
				twoObjects = true;

				if(packets.get(i).get(0).X < packets.get(i).get(1).X) {
					leftPacket = packets.get(i).get(0);
					rightPacket = packets.get(i).get(1);
				} else {
					rightPacket = packets.get(i).get(0);
					leftPacket = packets.get(i).get(1);
				}
			} else if(packets.get(i).size() == 1) {
				twoObjects = false;
				leftPacket = packets.get(i).get(0);
			} else {
				twoObjects = false;
			}

			SmartDashboard.putBoolean("Two Objects", twoObjects);

			// Loop through the packets for this signature.
			for(int j=0; j < packets.get(i).size(); j++) {
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": X: ", packets.get(i).get(j).X);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Y: ", packets.get(i).get(j).Y);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Width: ", packets.get(i).get(j).Width);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Height: ", packets.get(i).get(j).Height);
			}
		}
	}

	/**
	 * Checa si el valor 'x' del objeto está entre la tolerancia del centro asignado en el RobotMap.
	 */
	public boolean isLeftAligned() {
		return leftPacket.X >= 0 && leftPacket.X < RobotMap.PIXY_DIFF_LEFT + RobotMap.PIXY_TOLERANCE_LEFT;
	}

	public boolean isRightAligned() {
		return rightPacket.X >= 320 - RobotMap.PIXY_DIFF_RIGHT - RobotMap.PIXY_TOLERANCE_RIGHT &&
			rightPacket.X <= 320 - RobotMap.PIXY_DIFF_RIGHT + RobotMap.PIXY_TOLERANCE_RIGHT;
	}

	public boolean isAligned() {
		return isLeftAligned() && isRightAligned() && twoObjects;
	}
}