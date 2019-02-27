package org.usfirst.frc6647.Voltres.autonomous_step;

import org.usfirst.frc6647.Voltres.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public abstract class AutonomousStep_TilTake extends AutonomousStep{

	protected WPI_TalonSRX TiltakeTalon;
    protected AnalogPotentiometer pot;
	
	////////////constructor de la clase////////////////////
	public AutonomousStep_TilTake(){
		///nada
	}
	//////////////////////////////////////////////////////
	
	/////////////funcion para ligar los objetos a los del robot map//////////
	public void setup(){
		TiltakeTalon = RobotMap.liftMain;
		pot = RobotMap.tiltakePot;
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