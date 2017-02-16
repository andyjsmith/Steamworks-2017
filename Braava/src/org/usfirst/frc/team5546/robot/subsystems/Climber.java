package org.usfirst.frc.team5546.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    VictorSP climberMotor;
    
    public Climber() {
    	climberMotor = new VictorSP(6);
    	climberMotor.setInverted(true);
    }

    public void initDefaultCommand() {
    	
    }
    
    public void setEnabled(boolean enabled) {
    	if (enabled) {
    		climberMotor.set(1);
    	} else {
    		climberMotor.set(0);
    	}
    }
}

