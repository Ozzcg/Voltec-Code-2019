package org.usfirst.frc6647.Voltres.autonomous_steps;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc6647.Voltres.autonomous_step.AutonomousStep_TilTake;

public class MoveTilTakePot extends AutonomousStep_TilTake{
	private static final int TOLERANCE_POT = 250000; //pulsos por vuelta del encoder

	private double Actualposition = pot.get();
	private int Position;
	private Timer timer;
	
	
	public MoveTilTakePot(double Position){  //entrada en mm
		// Inicializar los parametros
		this.Position = (int)Position;
	}
	
	@Override
	public void start() {
		timer=new Timer();
		timer.reset();
		timer.start();
	}

	@Override
	public void run() {
		if((Actualposition-Position)<0) {
			TiltakeTalon.set(ControlMode.PercentOutput, 0.8);
		}else {
			TiltakeTalon.set(ControlMode.PercentOutput, -0.5);
		}
	}

	@Override
	public boolean isFinished() {
		Actualposition = pot.get();
		SmartDashboard.putNumber("enocderLiftAuto", Actualposition);
		if(Math.abs(Actualposition-Position)<=TOLERANCE_POT || timer.get()>5 ) {
			TiltakeTalon.set(ControlMode.PercentOutput, 0);
			return true;
		}else {
			return false;
		}
	}

}