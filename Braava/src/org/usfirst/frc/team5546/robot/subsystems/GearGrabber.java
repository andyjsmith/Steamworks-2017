package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGrabber extends Subsystem {


	public DoubleSolenoid grabber;
	public DoubleSolenoid lifter;
	
	public GearGrabber() {
		
		grabber = new DoubleSolenoid(0, 1);
		lifter = new DoubleSolenoid(2, 3);
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
}

