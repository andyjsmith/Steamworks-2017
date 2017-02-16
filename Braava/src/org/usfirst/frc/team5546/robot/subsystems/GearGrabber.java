package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGrabber extends Subsystem {


	DoubleSolenoid grabber;
	DoubleSolenoid lifter;
	Solenoid chute;
	
	public GearGrabber() {
		
		lifter = new DoubleSolenoid(0, 1);
		grabber = new DoubleSolenoid(2, 3);
		chute = new Solenoid(4);
	}
	
    public void initDefaultCommand() {
    }
    
    public void grabGear() {
    	grabber.set(DoubleSolenoid.Value.kForward);
    }
    
    public void releaseGear() {
    	grabber.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void liftGear() {
    	lifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void lowerGear() {
    	lifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void extendChute() {
    	chute.set(true);
    }
    
    public void retractChute() {
    	chute.set(false);
    	
    }
}

