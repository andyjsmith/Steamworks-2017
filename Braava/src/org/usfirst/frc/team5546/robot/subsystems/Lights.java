package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lights extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid visionLight;
	Solenoid redLights, blueLights;
	
	public Lights() {
		visionLight = new Solenoid(7);
		redLights = new Solenoid(5);
		blueLights = new Solenoid(6);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new StartVision());
    }
    
    public void setBlue() {
    	blueLights.set(true);
    }
    
    public void setRed() {
    	redLights.set(true);
    }
    
    public void setPurple() {
    	blueLights.set(true);
    	redLights.set(true);
    }
    
    public void turnOffLights() {
    	blueLights.set(false);
    	redLights.set(false);
    }
    
    public void toggleLights() {
    	if (blueLights.get() && redLights.get()) {
    		turnOffLights();
    	} else if (blueLights.get()) {
    		turnOffLights();
    		setPurple();
    	} else if (redLights.get()) {
    		turnOffLights();
    		setBlue();
    	} else {
    		turnOffLights();
    		setRed();
    	}
    }
    
    public void setVisionLights(boolean enabled) {
    	visionLight.set(enabled);
    }
}

