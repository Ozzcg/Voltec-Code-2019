package org.usfirst.frc6647.Voltres.autonomous_step;

import org.usfirst.frc6647.Voltres.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.DigitalInput;

public abstract class AutonomousStep_Lift extends AutonomousStep{

	protected WPI_TalonSRX lifTalon;
	protected DigitalInput topLimitSwitch; //limit switch superior del lift
    protected DigitalInput bottomLimitSwitch; //limit switch inferior del lift
    protected Encoder liftEncoder;
	
	////////////constructor de la clase////////////////////
	public AutonomousStep_Lift(){
		///nada
	}
	//////////////////////////////////////////////////////
	
	/////////////funcion para ligar los objetos a los del robot map//////////
	public void setup(){
		lifTalon = RobotMap.liftMain;
		topLimitSwitch= RobotMap.topLimitLift;
        bottomLimitSwitch= RobotMap.lowLimitLift;
        liftEncoder = RobotMap.liftEncoder;
	}
	////////////////////////////////////////////////////////////////////////
	
	// Metodo para inicializar el paso
	@Override
	public abstract void start();

	// Funcion iterativa del paso
	@Override
	public abstract void run();
	
	// Funcion que indica al autonomo si se termino el paso
	@Override
	public abstract boolean isFinished();
	
}
