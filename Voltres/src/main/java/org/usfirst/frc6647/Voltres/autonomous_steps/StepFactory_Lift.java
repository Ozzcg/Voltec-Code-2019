package org.usfirst.frc6647.Voltres.autonomous_steps;

import edu.wpi.first.wpilibj.Timer;

///////////Esta clase esta disenada para regresar todos los ojbetos de las clases que extiende a la clase de los pasos por systema//////////////////

public class StepFactory_Lift {

	public static MoveLiftEncoder MoveLiftEncoderToValue( double position){
		return new MoveLiftEncoder( position );
	}
	public static MoveLiftToSwitch move2Switch(double select){
		return new MoveLiftToSwitch (select);
	}
}