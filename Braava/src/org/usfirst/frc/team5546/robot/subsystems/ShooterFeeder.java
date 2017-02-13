package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterFeeder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP motor;
	
	public ShooterFeeder() {
		motor = new VictorSP(4);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(boolean enabled) {
    	if (enabled) {
    		motor.set(1);
    	} else {
    		motor.set(0);
    	}
    }
}

