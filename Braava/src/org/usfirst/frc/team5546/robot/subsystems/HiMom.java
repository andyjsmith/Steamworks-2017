package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.commands.hiMom.TurnOffHiMom;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * EL-wire "Hi Mom" sign
 */
public class HiMom extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid light;
	
	public HiMom() {
		light = new Solenoid(5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TurnOffHiMom());
    }
    
    public void turnOnMom() {
    	light.set(true);
    }
    
    public void turnOffMom() {
    	light.set(false);
    }
}

