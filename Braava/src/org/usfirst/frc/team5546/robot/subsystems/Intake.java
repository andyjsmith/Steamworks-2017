package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    VictorSP motor;
    
    public Intake() {
    	motor = new VictorSP(RobotMap.INTAKE_MOTOR_PORT);
    }

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setEnabled(boolean enabled) {
    	if (enabled) {
    		motor.set(1);
    	} else {
    		motor.set(0);
    	}
    }
}

