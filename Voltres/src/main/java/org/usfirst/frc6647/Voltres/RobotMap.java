/*
A este RobotMap le falta lo correspondiente al NAVX y a lo de visión

Ya estan mapeados todos los sensores y actuadores que se van a utilizar a exepcion de eso
*/

package org.usfirst.frc6647.Voltres;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class RobotMap{

    ///////////////////////////////NUMERO DE LOS CONTROLADORES//////////////////////////////
    
	private static final int TALON_FRONT_LEFT_CHASSIS_PORT = 4;         //TALON WITH ENCODER
	private static final int TALON_FRONT_RIGHT_CHASSIS_PORT = 8;        //TALON WITH ENCODER
    private static final int VICTOR_BACK_LEFT_CHASSIS_PORT = 2;         //VICTOR FOLLOWER LEFT
    private static final int VICTOR_BACK_RIGHT_CHASSIS_PORT = 7;        //VICTOR FOLLOWER RIGHT

    private static final int TALON_H_WHEEL_PORT = 3;                    //TALON H WHEEL

    private static final int VICTOR_CYLINDER_WHEELS_PORT = 11;          //WHEELS VICTOR

    private static final int VICTOR_INTAKE_MOTOR_RIGHT = 1;             //INTAKE VICTOR LEFT
    private static final int VICTOR_INTAKE_MOTOR_LEFT = 5;              //INTAKE VICTOR LEFT
        
    private static final int VICTOR_LIFT_MOTOR_ENCODER_PORT = 9;        //LIFT VICTOR ENCODER 
    private static final int VICTOR_LIFT_MOTOR_FOLLOWER_PORT = 10;      //LIFT VICTOR FOLLOWER

    private static final int VICTOR_TILTAKE_PORT = 12;                   //TILTAKE VICTOR

	/////////////////////////////////////////////////////////////////////////////////////////

	
    ////////////////////////////NUMERO DE LOS INPUTS DIGITALES///////////////////////////////
    
	private static final int DI_LIFT_LIMIT_DOWN_PORT = 0;	            //LIFT DOWN
    private static final int DI_LIFT_LIMIT_UP_PORT = 1; 	            //LIFT UP
    
    private static final int DI_TILTAKE_LIMIT_DOWN_PORT = 2;	        //TILTAKE DOWN
    private static final int DI_TILTAKE_LIMIT_UP_PORT = 3;	            //TILTAKE UP

    private static final int DI_BALL_PRESENT_PORT = 4;	                //BALL PRESENT

    private static final int DI_ENCODER_A_CHANNEL = 5;                  //A CHANNEL PORT
    private static final int DI_ENCODER_B_CHANNEL = 6;                  //B CHANNEL PORT

    private static final int DI_ULTRASONIC_REC = 7;                     //ULTRASONIC RECEIVE

    /////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////NUMERO DE LOS OUTPUTS DIGITALES//////////////////////////////

    private static final int DO_ULTRASONIC_SEND = 0;                     //ULTRASONIC SEND

    /////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////NUMERO DE LAS SEÑALES ANALOGAS///////////////////////////////
    
	private static final int AI_POT_PORT = 0;	                        //TILTAKE POTENTIOMETER

    /////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////NUMERO DE LAS SEÑALES PWM/////////////////////////////////////
    
	private static final int PWM_SERVO_PORT = 0;                        //CAM SERVO BASE

	/////////////////////////////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////SEÑALES DE LA PCM////////////////////////////////////

    private static final int SOL_FORWARD_H_PORT = 0;                   //H LEFT PISTON FORWARD
	private static final int SOL_REVERSE_H_PORT = 1;                   //H LEFT PISTON REVERSE


	private static final int SOL_FORWARD_FRONTCYLINDER_PORT = 4;              //FRONT PISTON FORWARD
	private static final int SOL_REVERSE_FRONTCYLINDER_PORT = 5;              //FRONT PISTON REVERSE
	private static final int SOL_FORWARD_BACKCYLINDER_PORT = 6;              //BACK PISTON FORWARD
    private static final int SOL_REVERSE_BACKCYLINDER_PORT = 7;              //BACK PISTON REVERSE
    
	//////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////CHASIS///////////////////////////////////////////
    
    public static WPI_TalonSRX frontLeft;
	public static WPI_TalonSRX frontRight;
	public static WPI_VictorSPX backLeft;
    public static WPI_VictorSPX backRight;

    public static WPI_TalonSRX hWheel;

    public static Ultrasonic ultrasense;

    public static DoubleSolenoid frontCylinder;
    public static DoubleSolenoid backCylinder;

    public static WPI_VictorSPX cylinderWheels;

	public static PowerDistributionPanel pdp;
    public static Compressor Compressor;
    
    public static final double RAMPDRIVE = 0.2;
    //poner aqui el NAVX

    //////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////INTAKE///////////////////////////////////////////

    public static WPI_VictorSPX intakeLeft;
    public static WPI_VictorSPX intakeRight;

    public static DoubleSolenoid cylinderH;

    public static DigitalInput ballPresent;

    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////TILTAKE///////////////////////////////////////////

    public static WPI_VictorSPX tilTake;
    public static AnalogPotentiometer tiltakePot;

    public static Servo camServo;

    public static DigitalInput topLimitTilt;
    public static DigitalInput lowLimitTilt;

    //////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////////////LIFT////////////////////////////////////////////

    public static WPI_VictorSPX liftMain;
    public static WPI_VictorSPX liftFollower;

    public static Encoder liftEncoder;

    public static DigitalInput topLimitLift;
    public static DigitalInput lowLimitLift;

    //////////////////////////////////////////////////////////////////////////////////////////


    public static void init(){
    
        /////////////////////////////////////////CHASIS///////////////////////////////////////////
        pdp = new PowerDistributionPanel();
        Compressor = new Compressor(0);
            
        frontLeft = new WPI_TalonSRX(TALON_FRONT_LEFT_CHASSIS_PORT);
        frontRight = new WPI_TalonSRX(TALON_FRONT_RIGHT_CHASSIS_PORT);
        backLeft = new WPI_VictorSPX(VICTOR_BACK_LEFT_CHASSIS_PORT);
        backRight = new WPI_VictorSPX(VICTOR_BACK_RIGHT_CHASSIS_PORT);

        hWheel = new WPI_TalonSRX(TALON_H_WHEEL_PORT);

        cylinderWheels = new WPI_VictorSPX(VICTOR_CYLINDER_WHEELS_PORT);
            
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(false);
        backRight.setInverted(false);

        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontRight.setNeutralMode(NeutralMode.Coast);
        backLeft.setNeutralMode(NeutralMode.Coast);
        backRight.setNeutralMode(NeutralMode.Coast);

        hWheel.setInverted(false);

        cylinderWheels.setInverted(false);
        ////
        frontLeft.configClosedloopRamp(RAMPDRIVE, 0);
        frontLeft.configOpenloopRamp(RAMPDRIVE, 0);

        //Quad Encoder Left
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        frontLeft.setSensorPhase(true);

        frontLeft.setSelectedSensorPosition(0, 0, 0); //resetea el sensor

        ////
        frontRight.configClosedloopRamp(RAMPDRIVE, 0);
        frontRight.configOpenloopRamp(RAMPDRIVE, 0);
        //Quad Encoder Right
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        frontRight.setSelectedSensorPosition(0, 0, 0);
        frontRight.setSensorPhase(true);
        frontRight.setSelectedSensorPosition(0, 0, 0); //resetea el sensor
        ////

        hWheel.configClosedloopRamp(RAMPDRIVE, 0);
        hWheel.configOpenloopRamp(RAMPDRIVE, 0);

        //Quad Encoder Left
        hWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        hWheel.setSensorPhase(true);

        hWheel.setSelectedSensorPosition(0, 0, 0); //resetea el sensor

        backLeft.configClosedloopRamp(RAMPDRIVE, 0);
        backLeft.configOpenloopRamp(RAMPDRIVE, 0);
        backRight.configClosedloopRamp(RAMPDRIVE, 0);
        backRight.configOpenloopRamp(RAMPDRIVE, 0);
        
        frontLeft.set(ControlMode.PercentOutput,0);
        frontRight.set(ControlMode.PercentOutput,0);
        backLeft.set(ControlMode.Follower,TALON_FRONT_LEFT_CHASSIS_PORT);
        backRight.set(ControlMode.Follower,TALON_FRONT_RIGHT_CHASSIS_PORT);
        
        frontCylinder = new DoubleSolenoid(SOL_FORWARD_FRONTCYLINDER_PORT, SOL_REVERSE_FRONTCYLINDER_PORT);
        backCylinder = new DoubleSolenoid(SOL_FORWARD_BACKCYLINDER_PORT, SOL_REVERSE_BACKCYLINDER_PORT);

        frontCylinder.set(DoubleSolenoid.Value.kReverse);
        backCylinder.set(DoubleSolenoid.Value.kReverse);

        ultrasense = new Ultrasonic(DO_ULTRASONIC_SEND, DI_ULTRASONIC_REC);

        //poner aqui el NAVX
        
        //////////////////////////////////////////////////////////////////////////////////////////
        
        /////////////////////////////////////////INTAKE///////////////////////////////////////////
        
        intakeLeft = new WPI_VictorSPX(VICTOR_INTAKE_MOTOR_LEFT);
        intakeRight = new WPI_VictorSPX(VICTOR_INTAKE_MOTOR_RIGHT);

        ballPresent = new DigitalInput(DI_BALL_PRESENT_PORT);

        intakeLeft.setInverted(true);
        intakeRight.setInverted(false);

        intakeLeft.setNeutralMode(NeutralMode.Brake);
        intakeRight.setNeutralMode(NeutralMode.Brake);

        intakeLeft.configClosedloopRamp(RAMPDRIVE, 0);
        intakeLeft.configOpenloopRamp(RAMPDRIVE, 0);
        intakeRight.configClosedloopRamp(RAMPDRIVE, 0);
        intakeRight.configOpenloopRamp(RAMPDRIVE, 0);

        intakeLeft.set(ControlMode.PercentOutput,0);
        intakeRight.set(ControlMode.PercentOutput,0);

        cylinderH = new DoubleSolenoid(SOL_FORWARD_H_PORT, SOL_REVERSE_H_PORT);

        cylinderH.set(DoubleSolenoid.Value.kReverse);
        
        //////////////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////////////TILTAKE///////////////////////////////////////////
        
        tilTake = new WPI_VictorSPX(VICTOR_TILTAKE_PORT);

        lowLimitTilt = new DigitalInput(DI_TILTAKE_LIMIT_DOWN_PORT);
        topLimitTilt = new DigitalInput(DI_TILTAKE_LIMIT_UP_PORT);

        tilTake.setInverted(false);

        tilTake.setNeutralMode(NeutralMode.Brake);

        tilTake.configClosedloopRamp(RAMPDRIVE, 0);
        tilTake.configOpenloopRamp(RAMPDRIVE, 0);

        tilTake.set(ControlMode.PercentOutput,0);

        tiltakePot = new AnalogPotentiometer(AI_POT_PORT);
        camServo = new Servo(PWM_SERVO_PORT);


        
        //////////////////////////////////////////////////////////////////////////////////////////
            
        //////////////////////////////////////////LIFT////////////////////////////////////////////
        
        liftMain = new WPI_VictorSPX(VICTOR_LIFT_MOTOR_ENCODER_PORT);
        liftFollower = new WPI_VictorSPX(VICTOR_LIFT_MOTOR_FOLLOWER_PORT);

        lowLimitLift = new DigitalInput(DI_LIFT_LIMIT_DOWN_PORT);
        topLimitLift = new DigitalInput(DI_LIFT_LIMIT_UP_PORT);

        liftEncoder = new Encoder(DI_ENCODER_A_CHANNEL, DI_ENCODER_B_CHANNEL, false, EncodingType.k4X);

        liftMain.configClosedloopRamp(RAMPDRIVE, 0);
        liftMain.configOpenloopRamp(RAMPDRIVE, 0);

        liftFollower.configClosedloopRamp(RAMPDRIVE, 0);
        liftFollower.configOpenloopRamp(RAMPDRIVE, 0);

        liftMain.setNeutralMode(NeutralMode.Brake);
        liftFollower.setNeutralMode(NeutralMode.Brake);

        liftMain.set(ControlMode.PercentOutput,0);
        liftFollower.set(ControlMode.Follower, VICTOR_LIFT_MOTOR_ENCODER_PORT);

        liftEncoder.reset();
        
        //////////////////////////////////////////////////////////////////////////////////////////
    }
}