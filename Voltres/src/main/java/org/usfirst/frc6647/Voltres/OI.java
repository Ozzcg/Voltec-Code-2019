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
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
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

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick1;
    public Joystick joystick2;
    public Joystick joystick3;

    public JoystickButton Button1;
    public JoystickButton Button2;
    public JoystickButton Button3;
    public JoystickButton Button4;
    public JoystickButton Button5;
    public JoystickButton Button6;
    public JoystickButton Button7;
    public JoystickButton Button8;
    public JoystickButton Button9;
    public JoystickButton Button10;
    public JoystickButton Button11;
    public JoystickButton Button12;
    public JoystickButton Button13;
    public JoystickButton Button14;

    public JoystickButton sButton1;
    public JoystickButton sButton2;
    public JoystickButton sButton3;
    public JoystickButton sButton4;
    public JoystickButton sButton5;
    public JoystickButton sButton6;
    public JoystickButton sButton7;
    public JoystickButton sButton8;

    public JoystickButton tButton2;
    public JoystickButton tButton3;
    public JoystickButton tButton7;
    public JoystickButton tButton8;

    public final Button dPadUp;
    public final Button dPadDown;
    private final double DPAD_THRESHOLD = 0.5;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick2 = new Joystick(1);

        joystick1 = new Joystick(0);

        joystick3 = new Joystick(2);

        // SmartDashboard Buttons
        /*
         * SmartDashboard.putData("GetHatchFeed", new GetHatchFeed());
         * SmartDashboard.putData("GetHatchFloor", new GetHatchFloor());
         * SmartDashboard.putData("GetBallFeed", new GetBallFeed());
         * SmartDashboard.putData("GetBallFloor", new GetBallFloor());
         * SmartDashboard.putData("Latch H", new LatchH());
         * SmartDashboard.putData("MovementStance", new MovementStance());
         * SmartDashboard.putData("Align tape", new Aligntape());
         * SmartDashboard.putData("BallIn", new BallIn());
         * SmartDashboard.putData("BallOut", new BallOut());
         * SmartDashboard.putData("BallOutLeft", new BallOutLeft());
         * SmartDashboard.putData("BallOutRight", new BallOutRight());
         * SmartDashboard.putData("CloseIn", new CloseIn());
         * SmartDashboard.putData("Uturn", new Uturn());
         */

        /*
         * SmartDashboard.putData("HatchLow", new HatchLow());
         * SmartDashboard.putData("HatchMid", new HatchMid());
         * SmartDashboard.putData("HatchHigh", new HatchHigh());
         * SmartDashboard.putData("Latch H", new LatchH());
         * SmartDashboard.putData("BallLow", new BallLow());
         * SmartDashboard.putData("BallMid", new BallMid());
         * SmartDashboard.putData("BallHigh", new BallHigh());
         * SmartDashboard.putData("BallCargo", new BallCargo());
         * SmartDashboard.putData("LiftUpManual", new LiftUpManual());
         * SmartDashboard.putData("LiftDownManual", new LiftDownManual());
         * SmartDashboard.putData("IntakeUpManual", new TilTakeUpManual());
         * SmartDashboard.putData("IntakeDownManual", new TilTakeDownManual());
         * SmartDashboard.putData("HAB3", new HAB3()); SmartDashboard.putData("HAB2",
         * new HAB2()); SmartDashboard.putData("MoveFrontHAB", new MoveFrontHAB());
         * SmartDashboard.putData("MoveBackHAB", new MoveBackHAB());
         */
        SmartDashboard.putData("GyroAlign", new GyroAlign());
        SmartDashboard.putData("VisionAlign", new VisionAlign());
        SmartDashboard.putData("Align", new Align());
        SmartDashboard.putData("ZeroYaw", new ZeroYaw());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        dPadUp = buttonFromPOV(joystick1, 0);
        dPadDown = buttonFromPOV(joystick1, 180);

        Button1 = new JoystickButton(joystick1, 1);
        Button2 = new JoystickButton(joystick1, 2);
        Button3 = new JoystickButton(joystick1, 3);
        Button4 = new JoystickButton(joystick1, 4);
        Button5 = new JoystickButton(joystick1, 5);
        Button6 = new JoystickButton(joystick1, 6);
        Button7 = new JoystickButton(joystick1, 7);
        Button8 = new JoystickButton(joystick1, 8);
        Button9 = new JoystickButton(joystick1, 9);
        Button10 = new JoystickButton(joystick1, 10);
        Button11 = new JoystickButton(joystick1, 11);
        Button12 = new JoystickButton(joystick1, 12);
        Button13 = new JoystickButton(joystick1, 13);
        Button14 = new JoystickButton(joystick1, 14);
        
        sButton1 = new JoystickButton(joystick2, 1);
        sButton2 = new JoystickButton(joystick2, 2);
        sButton3 = new JoystickButton(joystick2, 3);
        sButton4 = new JoystickButton(joystick2, 4);

        sButton5 = new JoystickButton(joystick2, 5);
        sButton6 = new JoystickButton(joystick2, 6);
        sButton7 = new JoystickButton(joystick2, 8);
        sButton8 = new JoystickButton(joystick2, 7);

        ////////////////// HAB CONTROL///////////

        tButton2 = new JoystickButton(joystick3, 2);
        tButton3 = new JoystickButton(joystick3, 3);
        tButton7 = new JoystickButton(joystick3, 7);
        tButton8 = new JoystickButton(joystick3, 8);


        // SmartDashboard.putNumber("Degrees", joystick1.getDirectionDegrees());

        // MELI Mache CONFIG
        // Button4.whenPressed(new VisionAlignment());
        Button5.whileHeld(new BallIn());
        Button6.whileHeld(new BallOut());
        Button7.whileHeld(new Slide(true));
        Button8.whileHeld(new Slide(false));

        // DAVID/MACHE/IAN CONFIG
        /*
         * Button7.whileHeld(new BallIn()); Button8.whileHeld(new BallOut());
         */

        //Button3.whileHeld(new LatchH());
        

        Button4.whileHeld(new LimiterMaxSpeed());
        Button1.whileHeld(new LimiterSlowSpeed());

        Button11.toggleWhenPressed(new GyroAlign());
        dPadUp.whileHeld(new GyroAlign());
        dPadDown.whileHeld(new GyroAlign());
        //Button12.toggleWhenPressed(new VisionAlign());
        Button14.whileHeld(new Align());
        Button2.toggleWhenPressed(new LatchH());
        Button3.whenPressed(new PushHatch());
        
        /*
         * Button6.whileHeld(new LiftUpManual()); Button5.whileHeld(new
         * LiftDownManual()); Button1.whileHeld(new HAB3()); Button14.whileHeld(new
         * Reset_Encoders()); Button13.whileHeld(new MoveBackHAB());
         */

        // sButton1.whileHeld(new TilTake());

        // sButton4.whenPressed(new LatchH());

        ///////// PARA COMPETENCIA////////

        sButton1.whileHeld(new HatchLow());
        sButton3.whileHeld(new HatchMid());
        sButton2.whileHeld(new GetBallFloor());
        sButton4.whileHeld(new BallMid());
        sButton6.whileHeld(new HatchHigh());
        sButton5.whileHeld(new LiftDownManual());
        sButton8.whileHeld(new Reset_Encoders());

        //////// COMPETENCIA TERCER CONTROL/////////

        tButton3.whenPressed(new BCFWD());
        tButton2.whenPressed(new FCFWD());
        tButton8.whenPressed(new BCBWD());
        tButton7.whenPressed(new FCBWD());

        /*
         * sButton2.whileHeld(new HatchLow()); sButton3.whileHeld(new HatchMid());
         * sButton4.whileHeld(new HatchHigh());
         */

        /*
         * sButton5.whenPressed(new BCFWD()); sButton6.whenPressed(new FCFWD());
         * sButton7.whenPressed(new BCBWD()); sButton8.whenPressed(new FCBWD());
         * sButton1.whileHeld(new TilTake());
         */

        /*
         * sButton4.whenPressed(new BCFWD()); sButton2.whenPressed(new FCFWD());
         * sButton3.whenPressed(new BCBWD()); sButton1.whenPressed(new FCBWD());
         */

        /*
         * sButton5.whenPressed(new HABMoveBack()); sButton6.whenPressed(new
         * HABMoveFront());
         */

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    private Button buttonFromPOV(GenericHID controller) {
        return new Button() {
            @Override
            public boolean get() {
                return (controller.getPOV()) > -1;
            }
        };
    }
    private Button buttonFromPOV(GenericHID controller, int angle) {
        return new Button() {
            @Override
            public boolean get() {
                return (controller.getPOV()) == angle;
            }
        };
    }
}