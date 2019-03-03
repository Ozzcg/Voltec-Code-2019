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

import org.usfirst.frc6647.Voltres.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc6647.Voltres.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick1;
    public Joystick joystick2;

    public JoystickButton Button1;
    public JoystickButton Button2;
    public JoystickButton Button12;
    public JoystickButton Button3;
    public JoystickButton Button4;
    public JoystickButton Button5;
    public JoystickButton Button6;
    public JoystickButton Button7;
    public JoystickButton Button8;
    public JoystickButton Button14;
    public JoystickButton Button13;

    public JoystickButton sButton1;
    public JoystickButton sButton2;
    public JoystickButton sButton3;
    public JoystickButton sButton4;

    public JoystickButton sButton5;
    public JoystickButton sButton6;
    public JoystickButton sButton7;
    public JoystickButton sButton8;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick2 = new Joystick(1);
        
        joystick1 = new Joystick(0);
        


        // SmartDashboard Buttons
        /*SmartDashboard.putData("GetHatchFeed", new GetHatchFeed());
        SmartDashboard.putData("GetHatchFloor", new GetHatchFloor());
        SmartDashboard.putData("GetBallFeed", new GetBallFeed());
        SmartDashboard.putData("GetBallFloor", new GetBallFloor());
        SmartDashboard.putData("Latch H", new LatchH());
        SmartDashboard.putData("MovementStance", new MovementStance());
        SmartDashboard.putData("Align tape", new Aligntape());
        SmartDashboard.putData("BallIn", new BallIn());
        SmartDashboard.putData("BallOut", new BallOut());
        SmartDashboard.putData("BallOutLeft", new BallOutLeft());
        SmartDashboard.putData("BallOutRight", new BallOutRight());
        SmartDashboard.putData("CloseIn", new CloseIn());
        SmartDashboard.putData("Uturn", new Uturn());*/
        SmartDashboard.putData("HatchLow", new HatchLow());
        SmartDashboard.putData("HatchMid", new HatchMid());
        SmartDashboard.putData("HatchHigh", new HatchHigh());
        SmartDashboard.putData("Latch H", new LatchH());
        /*SmartDashboard.putData("BallLow", new BallLow());
        SmartDashboard.putData("BallMid", new BallMid());
        SmartDashboard.putData("BallHigh", new BallHigh());
        SmartDashboard.putData("BallCargo", new BallCargo());
        SmartDashboard.putData("LiftUpManual", new LiftUpManual());
        SmartDashboard.putData("LiftDownManual", new LiftDownManual());
        SmartDashboard.putData("IntakeUpManual", new TilTakeUpManual());
        SmartDashboard.putData("IntakeDownManual", new TilTakeDownManual());
        SmartDashboard.putData("HAB3", new HAB3());
        SmartDashboard.putData("HAB2", new HAB2());
        SmartDashboard.putData("MoveFrontHAB", new MoveFrontHAB());
        SmartDashboard.putData("MoveBackHAB", new MoveBackHAB());*/
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        Button1 = new JoystickButton(joystick1, 1);
        Button2 = new JoystickButton(joystick1, 2);
        Button12  = new JoystickButton(joystick1, 12);
        Button3  = new JoystickButton(joystick1, 3);
        Button4  = new JoystickButton(joystick1, 4);
        Button5  = new JoystickButton(joystick1, 5);
        Button6  = new JoystickButton(joystick1, 6);
        Button7  = new JoystickButton(joystick1, 7);
        Button8  = new JoystickButton(joystick1, 8);
        Button14  = new JoystickButton(joystick1, 14);
        Button13  = new JoystickButton(joystick1, 13);
        sButton1 = new JoystickButton(joystick2, 1);
        sButton2 = new JoystickButton(joystick2, 2);
        sButton3  = new JoystickButton(joystick2, 3);
        sButton4  = new JoystickButton(joystick2, 4);

        sButton5  = new JoystickButton(joystick2, 5);
        sButton6  = new JoystickButton(joystick2, 6);
        sButton7  = new JoystickButton(joystick2, 7);
        sButton8  = new JoystickButton(joystick2, 8);

        Button7.whileHeld(new BallIn());
        Button8.whileHeld(new BallOut());
        Button3.whileHeld(new LatchH());
        Button4.whileHeld(new TilTakeUpManual());
        Button2.whileHeld(new TilTakeDownManual());
        Button6.whileHeld(new LiftUpManual());
        Button5.whileHeld(new LiftDownManual());
        Button1.whileHeld(new HAB3());
        Button14.whileHeld(new Reset_Encoders());
        Button13.whileHeld(new MoveBackHAB());

        sButton4.whenPressed(new LatchH());
        sButton1.whileHeld(new HatchLow());
        sButton2.whileHeld(new HatchMid());
        sButton3.whileHeld(new HatchHigh());

        sButton5.whenPressed(new BCFWD());
        sButton6.whenPressed(new FCFWD());
        sButton7.whenPressed(new BCBWD());
        sButton8.whenPressed(new FCBWD());



    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

