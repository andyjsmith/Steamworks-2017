package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid gearLight;
	Solenoid highGoalLight;
	
	public Vision() {
		gearLight = new Solenoid(7);
		highGoalLight = new Solenoid(6);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new StartVision());
    }
    
    public void setGearLight(boolean enabled) {
    	gearLight.set(enabled);
    }
    
    public void setHighGoalLight(boolean enabled) {
    	highGoalLight.set(enabled);
    }
}

