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
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
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

    //Talon en chasis de prueba
    //private static final int VICTOR_CYLINDER_WHEELS_PORT = 11;          //WHEELS VICTOR

    private static final int VICTOR_INTAKE_MOTOR_RIGHT = 1;             //INTAKE VICTOR LEFT
    private static final int VICTOR_INTAKE_MOTOR_LEFT = 5;              //INTAKE VICTOR LEFT
     
    //////////////////////////////////
    private static final int VICTOR_LIFT_MOTOR_ENCODER_PORT = 9;        //LIFT VICTOR ENCODER 
    private static final int VICTOR_LIFT_MOTOR_FOLLOWER_PORT = 10;      //LIFT VICTOR FOLLOWER
    ////Talons en Chasis de prueba////

    private static final int VICTOR_TILTAKE_PORT = 12;                   //TILTAKE VICTOR

    public static final int CLIMB_FRONT_TALON_PORT = 13;                //ESCALADOR FRONT
    public static final int CLIMB_BACK_LEFT_TALON_PORT = 14;            //ESCALADOR BACK
    public static final int CLIMB_WHEELS_TALON_PORT = 15;               //ESCALADOR DOWN WHEELS

	/////////////////////////////////////////////////////////////////////////////////////////

	
    ////////////////////////////NUMERO DE LOS INPUTS DIGITALES///////////////////////////////
    
	private static final int DI_LIFT_LIMIT_DOWN_PORT = 1;	            //LIFT DOWN
    private static final int DI_LIFT_LIMIT_UP_PORT = 2; 	            //LIFT UP
    
    private static final int DI_TILTAKE_LIMIT_DOWN_PORT = 3;	        //TILTAKE DOWN
    private static final int DI_TILTAKE_LIMIT_UP_PORT = 4;	            //TILTAKE UP

    private static final int DI_BALL_PRESENT_PORT = 5;	                //BALL PRESENT

    private static final int DI_ENCODER_A_CHANNEL = 6;                  //A CHANNEL PORT
    private static final int DI_ENCODER_B_CHANNEL = 7;                  //B CHANNEL PORT

    private static final int DI_ULTRASONIC_REC = 8;                     //ULTRASONIC RECEIVE

    /////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////NUMERO DE LOS OUTPUTS DIGITALES//////////////////////////////

    private static final int DO_ULTRASONIC_SEND = 0;                     //ULTRASONIC SEND

    /////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////NUMERO DE LAS SEÑALES ANALOGAS///////////////////////////////
    
	private static final int AI_POT_PORT = 1;	                        //TILTAKE POTENTIOMETER

    /////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////NUMERO DE LAS SEÑALES PWM/////////////////////////////////////
    
	private static final int PWM_SERVO_PORT = 0;                        //CAM SERVO BASE

	/////////////////////////////////////////////////////////////////////////////////////////
	
    ////////////////////////////////////SEÑALES DE LA PCM////////////////////////////////////

    private static final int SOL_FORWARD_H_PORT = 3;                   
    private static final int SOL_REVERSE_H_PORT = 2;
    private static final int SOL_PUSH_HATCH = 1;                   

    /*
	private static final int SOL_FORWARD_FRONTCYLINDER_PORT = 4;              //FRONT PISTON FORWARD
	private static final int SOL_REVERSE_FRONTCYLINDER_PORT = 5;              //FRONT PISTON REVERSE
	private static final int SOL_FORWARD_BACKCYLINDER_PORT = 6;              //BACK PISTON FORWARD
    private static final int SOL_REVERSE_BACKCYLINDER_PORT = 7;              //BACK PISTON REVERSE
    */
    
	//////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////CHASIS///////////////////////////////////////////
    
    public static WPI_TalonSRX frontLeft;
	public static WPI_TalonSRX frontRight;
	public static WPI_VictorSPX backLeft;
    public static WPI_VictorSPX backRight;

    public static WPI_TalonSRX hWheel;

    public static Ultrasonic ultrasense;

    ////////////////////

	public static PowerDistributionPanel pdp;
    public static Compressor Compressor;
    
    public static final double RAMPDRIVE = 0.2;
    public static AHRS NAVX;
    //////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////INTAKE///////////////////////////////////////////

    public static WPI_VictorSPX intakeLeft;
    public static WPI_VictorSPX intakeRight;

    public static Solenoid cylinderH;
    public static Solenoid cylinderHR;
    public static Solenoid pushHatch;

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

    /////////////////////////////////////////PID/////////////////////////////////////////////
    public static double chassisEncoderP = 0.0;
    public static double chassisEncoderI = 0.0;
    public static double chassisEncoderD = 0.0;

    public static double chassisLeftP = .25;
    public static double chassisLeftI = 0.0;
    public static double chassisLeftD = 0.0;
    public static double chassisLeftF = 1023/2200;

    public static double chassisRightP = .25;
    public static double chassisRightI = 0.0;
    public static double chassisRightD = 0.0;
    public static double chassisRightF = 1023/2200;

    public static double chassisMidP = 0.0;
    public static double chassisMidI = 0.0;
    public static double chassisMidD = 0.0;
    public static double chassisMidF = 0.0;

    public static double liftP = 0.00004;
    public static double liftI = 0.0000009015;
    public static double liftD = 0.000132;

    public static double intakeP = 2.95;
    public static double intakeI = 0.3;
    public static double intakeD = 0.22;

    public static double gyroP = 0.02; // Hay que ajustar.
	public static double gyroI = 0.0000025;
	public static double gyroD = 0.0025;
    //////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////ELEVATOR VALUES////////////////////////////////////////

    //Usados

    public static final int hatchLv1 = 20000;

    //Cambiar
    public static final int hatchLv2 = 230000;
    public static final int hatchLv3 = 350000;

    public static final int ballLevel1 = 235000;
    /////////////

    public static final int ballfloor = 135000;

    public static final int ballLevel2 = 260000;
    public static final int ballLevel3 = 385000;

    public static final int cargoship = 310000;
    
    //Tiltake Values

    //////////////////////////////////////////////////////////////////////////////////////////

    public static double visionP = 0.07;
    public static double visionI = 0;
    public static double visionD = 0;
    public static double visionOffset = 3;

    public static WPI_VictorSPX climbFront;
    public static WPI_VictorSPX climbBackLeft;
    public static WPI_VictorSPX climbWheels;

    public static void init(){
    
        /////////////////////////////////////////CHASIS///////////////////////////////////////////
        pdp = new PowerDistributionPanel();
        Compressor = new Compressor(0);

        NAVX = new AHRS(SPI.Port.kMXP);//NAVX
        NAVX.reset();
            
        frontLeft = new WPI_TalonSRX(TALON_FRONT_LEFT_CHASSIS_PORT);
        frontRight = new WPI_TalonSRX(TALON_FRONT_RIGHT_CHASSIS_PORT);
        backLeft = new WPI_VictorSPX(VICTOR_BACK_LEFT_CHASSIS_PORT);
        backRight = new WPI_VictorSPX(VICTOR_BACK_RIGHT_CHASSIS_PORT);

        hWheel = new WPI_TalonSRX(TALON_H_WHEEL_PORT);

        //cylinderWheels = new WPI_TalonSRX(VICTOR_CYLINDER_WHEELS_PORT);
        
        //cylinderWheels = new WPI_VictorSPX(VICTOR_CYLINDER_WHEELS_PORT);
        
        frontLeft.setInverted(true);
        backLeft.setInverted(true);
        frontRight.setInverted(false);
        backRight.setInverted(false);

        frontLeft.setNeutralMode(NeutralMode.Coast);
        frontRight.setNeutralMode(NeutralMode.Coast);
        backLeft.setNeutralMode(NeutralMode.Coast);
        backRight.setNeutralMode(NeutralMode.Coast);

        hWheel.setInverted(false);

        //cylinderWheels.setInverted(false);
        ////
        frontLeft.configClosedloopRamp(RAMPDRIVE, 20);
        frontLeft.configOpenloopRamp(RAMPDRIVE, 20);

        //Quad Encoder Left
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        frontLeft.setSensorPhase(true);
        frontLeft.setSelectedSensorPosition(0, 0, 0); //resetea el sensor
        frontLeft.config_kP(0, chassisLeftP);
        frontLeft.config_kI(0, chassisLeftI);
        frontLeft.config_kD(0, chassisLeftD);
        frontLeft.config_kF(0, chassisLeftF);

        ////
        frontRight.configClosedloopRamp(RAMPDRIVE, 20);
        frontRight.configOpenloopRamp(RAMPDRIVE, 20);
        //Quad Encoder Right

        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        frontRight.setSensorPhase(true);
        frontRight.setSelectedSensorPosition(0, 0, 0); //resetea el sensor
        frontRight.config_kP(0, chassisRightP);
        frontRight.config_kI(0, chassisRightI);
        frontRight.config_kD(0, chassisRightD);
        frontRight.config_kF(0, chassisRightF);
        ////
        hWheel.configClosedloopRamp(RAMPDRIVE, 1000);
        hWheel.configOpenloopRamp(RAMPDRIVE, 1000);

        //Quad Encoder Left
        hWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        hWheel.setSensorPhase(true);
        
        hWheel.setSelectedSensorPosition(0, 0, 0); //resetea el sensor
        hWheel.config_kP(0, chassisMidP);
        hWheel.config_kI(0, chassisMidI);
        hWheel.config_kD(0, chassisMidD);
        hWheel.config_kF(0, chassisMidF);
        ///

        backLeft.configClosedloopRamp(RAMPDRIVE, 0);
        backLeft.configOpenloopRamp(RAMPDRIVE, 0);
        backRight.configClosedloopRamp(RAMPDRIVE, 0);
        backRight.configOpenloopRamp(RAMPDRIVE, 0);
        
        frontLeft.set(ControlMode.PercentOutput,0);
        frontRight.set(ControlMode.PercentOutput,0);
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

        ultrasense = new Ultrasonic(DO_ULTRASONIC_SEND, DI_ULTRASONIC_REC);

        
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

        cylinderH = new Solenoid(SOL_FORWARD_H_PORT);
        cylinderHR = new Solenoid(SOL_REVERSE_H_PORT);
        pushHatch = new Solenoid(SOL_PUSH_HATCH);

        pushHatch.set(false);
        cylinderH.set(false);
        cylinderHR.set(false);
        
        //////////////////////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////////////TILTAKE///////////////////////////////////////////
        
        tilTake = new WPI_VictorSPX(VICTOR_TILTAKE_PORT);

        lowLimitTilt = new DigitalInput(DI_TILTAKE_LIMIT_DOWN_PORT);
        topLimitTilt = new DigitalInput(DI_TILTAKE_LIMIT_UP_PORT);

        tilTake.setInverted(true);

        tilTake.setNeutralMode(NeutralMode.Brake);

        tilTake.configClosedloopRamp(RAMPDRIVE, 0);
        tilTake.configOpenloopRamp(RAMPDRIVE, 0);

        tilTake.set(ControlMode.PercentOutput,0);

        tiltakePot = new AnalogPotentiometer(AI_POT_PORT, 3600, -8);
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
        liftFollower.follow(liftMain);

        liftEncoder.reset();
        
        //////////////////////////////////////////////////////////////////////////////////////////

        climbFront = new WPI_VictorSPX(CLIMB_FRONT_TALON_PORT);
        climbBackLeft = new WPI_VictorSPX(CLIMB_BACK_LEFT_TALON_PORT);
        climbWheels = new WPI_VictorSPX(CLIMB_WHEELS_TALON_PORT);

        climbFront.configClosedloopRamp(RAMPDRIVE, 0);
        climbFront.configOpenloopRamp(RAMPDRIVE, 0);
        
        climbBackLeft.configClosedloopRamp(RAMPDRIVE, 0);
        climbBackLeft.configOpenloopRamp(RAMPDRIVE, 0);

        climbWheels.configClosedloopRamp(RAMPDRIVE, 0);
        climbWheels.configOpenloopRamp(RAMPDRIVE, 0);

        climbFront.setNeutralMode(NeutralMode.Brake);
        climbBackLeft.setNeutralMode(NeutralMode.Brake);
        climbWheels.setNeutralMode(NeutralMode.Coast);

        climbFront.set(ControlMode.PercentOutput, 0);
        climbBackLeft.set(ControlMode.PercentOutput, 0);
    }
}