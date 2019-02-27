package org.usfirst.frc6647.Voltres.autonomous_steps;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import org.usfirst.frc6647.Voltres.autonomous_step.AutonomousStep_Lift;

/////para subir o bajar el elevador con tiempo y seguridad del switch////////////////////////

public class MoveLiftToSwitch extends AutonomousStep_Lift{
	private double power;
	private double select;
	private Timer timer;
	
	public MoveLiftToSwitch(double select){
		this.select=select;
	}
	
	@Override
	public void start() {
		timer=new Timer();
		timer.reset();
		timer.start();
		if(select==1) {  //abajo
			power=-0.5;
		}else if(select==-1) { //arriba
			power=0.8;
		}else {
			power=0;
		}
	}

	@Override
	public void run() {
		lifTalon.set(ControlMode.PercentOutput, power);
	}

	@Override
	public boolean isFinished() { //abajo
		if(select==1) {
			if(!bottomLimitSwitch.get() || timer.get()>5) {
				lifTalon.set(ControlMode.PercentOutput, 0);
				if(timer.get()<=5) {
					liftEncoder.reset();
				}
				return true;
			}
			return false;
		}else if(select==-1) {  //arriba
			if(!topLimitSwitch.get() || timer.get()>5) {
				return true;
			}
			return false;
		}
		return true;
	}
}