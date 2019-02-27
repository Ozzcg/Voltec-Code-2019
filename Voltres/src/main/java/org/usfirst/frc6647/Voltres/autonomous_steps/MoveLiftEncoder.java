package org.usfirst.frc6647.Voltres.autonomous_steps;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc6647.Voltres.autonomous_step.AutonomousStep_Lift;

public class MoveLiftEncoder extends AutonomousStep_Lift{
	private static final int TOLERANCE_ENCODER = 250000; //pulsos por vuelta del encoder

	private int Actualposition = liftEncoder.get();
	private int Position;
	private Timer timer;
	
	
	public MoveLiftEncoder(double Position){  //entrada en mm
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
			lifTalon.set(ControlMode.PercentOutput, 0.8);
		}else {
			lifTalon.set(ControlMode.PercentOutput, -0.4);
		}
	}

	@Override
	public boolean isFinished() {
		Actualposition = (int)(liftEncoder.get());
		SmartDashboard.putNumber("enocderLiftAuto", Actualposition);
		if(Math.abs(Actualposition-Position)<=TOLERANCE_ENCODER || timer.get()>2 ) {
			lifTalon.set(ControlMode.PercentOutput, 0);
			return true;
		}else {
			return false;
		}
	}

}