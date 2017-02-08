package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid light;
	
	public Vision() {
		light = new Solenoid(7);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new StartVision());
    }
    
    public void setLight(boolean enabled) {
    	light.set(enabled);
    }
}

