package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Ball shooter
 */
public class Shooter extends Subsystem {
	
	public CANTalon talon;
	//public static final double IDEAL_SPEED = 26600;
	public static final double IDEAL_SPEED = 26600;
	
	public Shooter() {
		talon = new CANTalon(RobotMap.SHOOTER_MOTOR_DEVICE_ID);
		talon.setInverted(true);
//		talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
//		talon.changeControlMode(TalonControlMode.Speed);
//		talon.configMaxOutputVoltage(12);
//		talon.configPeakOutputVoltage(+12.0f, -12.0f);
//		talon.configNominalOutputVoltage(+0.0f, -0.0f);
//		talon.setF(0.0095);
//		talon.setP(0.07);
//		talon.setI(0);
//		talon.setD(0.0025);
		
	}

    public void initDefaultCommand() {
        //setDefaultCommand(new KeepShooterSpeed());
    }
    
    public void setSpeed() {
    	
    }
}

