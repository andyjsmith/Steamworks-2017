package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterFeeder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP feeder, agitator;
	
	public ShooterFeeder() {
		feeder = new VictorSP(4);
		agitator = new VictorSP(7);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(boolean enabled) {
    	if (enabled) {
    		feeder.set(0.75); //0.35
    		agitator.set(Robot.oi.agitatorFixBtn.get() ? 1 : -1);
    	} else {
    		feeder.set(0);
    		agitator.set(0);
    	}
    }
}

