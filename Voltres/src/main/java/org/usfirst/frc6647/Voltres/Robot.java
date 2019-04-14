// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc6647.Voltres;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc6647.Voltres.commands.*;

//import org.usfirst.frc6647.Voltres.commands.HatchHigh;
//import org.usfirst.frc6647.Voltres.commands.HatchLow;
//import org.usfirst.frc6647.Voltres.commands.HatchMid;
import org.usfirst.frc6647.Voltres.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;
	Command drivestart_command;
	Command resetall_command;

	SendableChooser<Command> chooser = new SendableChooser<>();

	public static OI oi;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Robot_hWheel hWheel;
	public static Robot_Intake intake;
	public static Robot_TilTake tilTake;
	public static Robot_Drive robotDrive;
	public static Robot_Control control;
	public static LiftWithPID liftWithPID;
	public static Vision vision;
	public JoystickButton Button2;
	public Joystick joystick1;

	// public static HatchLow hatchLow;
	// public static HatchMid hatchMid;
	// public static HatchHigh hatchHigh;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		hWheel = new Robot_hWheel();
		intake = new Robot_Intake();
		tilTake = new Robot_TilTake();
		robotDrive = new Robot_Drive();
		control = new Robot_Control();
		liftWithPID = new LiftWithPID();
		vision = new Vision();

		/*
		 * UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		 * camera.setResolution(640,480);
		 */

		// hatchLow = new HatchLow();
		// hatchMid = new HatchMid();
		// hatchHigh = new HatchHigh();
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// Add commands to Autonomous Sendable Chooser
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		SmartDashboard.putData("Auto mode", chooser);

		// CameraServer.getInstance().startAutomaticCapture();

		// Robot.control.turnCompressorOff(); //Activa el ciclo automatico de can del
		// compresor
	}

	@Override
	public void robotPeriodic() {
		SmartDashboard.putNumber("Degrees", oi.joystick1.getPOV());
		SmartDashboard.putNumber("NavXYaw", RobotMap.NAVX.getYaw());
	}

	/**
	 * This function is called when the disabled button is hit. You can use it to
	 * reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		joystick1 = new Joystick(0);
		Button2 = new JoystickButton(joystick1, 1);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		robotDrive.Main_Drive();

		if (oi.sButton6.get()) {
			liftWithPID.Lift_Up();
		} else {
			if (oi.sButton5.get()) {
				liftWithPID.Lift_Down();
			} else {
				liftWithPID.Stop_Lift();
			}
		}
		tilTake.Tilt_Up();
		// tilTake.Tilt_Down();

		Button2.whileHeld(new LatchH());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		/*
		 * SmartDashboard.putNumber("Kp", RobotMap.liftP);
		 * SmartDashboard.putNumber("Ki", RobotMap.liftI);
		 * SmartDashboard.putNumber("Kd", RobotMap.liftD);
		 */

		SmartDashboard.putNumber("gyroP", RobotMap.gyroP);
		SmartDashboard.putNumber("gyroI", RobotMap.gyroI);
		SmartDashboard.putNumber("gyroD", RobotMap.gyroD);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
		/*
		 * RobotMap.liftP = SmartDashboard.getNumber("Kp", RobotMap.liftP);
		 * RobotMap.liftI = SmartDashboard.getNumber("Ki", RobotMap.liftI);
		 * RobotMap.liftD = SmartDashboard.getNumber("Kd", RobotMap.liftD);
		 */
		// driveWPID.Main_Drive();
		robotDrive.Main_Drive();

		vision.run();
		if (oi.joystick2.getRawAxis(3) > 0.2) {
			tilTake.Tilt_Up();
		} else {
			if (oi.joystick2.getRawAxis(2) > 0.2) {
				tilTake.Tilt_Down();
			} else {
				tilTake.Tilt_Down();
			}

		}

		RobotMap.gyroP = SmartDashboard.getNumber("gyroP", RobotMap.gyroP);
		RobotMap.gyroI = SmartDashboard.getNumber("gyroI", RobotMap.gyroI);
		RobotMap.gyroD = SmartDashboard.getNumber("gyroD", RobotMap.gyroD);
		robotDrive.setPIDValues();

	}
}
