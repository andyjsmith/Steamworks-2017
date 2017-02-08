package org.usfirst.frc.team5546.robot.subsystems;

import org.usfirst.frc.team5546.robot.ADIS16448_IMU;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {
	
	public ADIS16448_IMU imu;
	public RobotDrive drive;
	public Encoder encoderLeft;
	
	public final double DISTANCE_PER_FOOT = 1287;
	
	public boolean rotate = false;
	
	public VictorSP frontLeftMotor = new VictorSP(0);
	public VictorSP rearLeftMotor = new VictorSP(1);
	public VictorSP frontRightMotor = new VictorSP(2);
	public VictorSP rearRightMotor = new VictorSP(3);

    // Initialize your subsystem here
    public DriveTrain() {
    	super(4, 0.1, 0);
    	setAbsoluteTolerance(20);
    	//setInputRange(-360, 360);
    	imu = new ADIS16448_IMU();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    	drive.setSafetyEnabled(false);
    	
    	encoderLeft = new Encoder(0, 1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        if (rotate) {
        	return imu.getAngleZ();
        } else {
        	return encoderLeft.getDistance();
        }
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if (rotate) {
    		drive.tankDrive(output * 0.6, -output * 0.6);
    	} else {
    		drive.arcadeDrive(output * 0.4, imu.getAngleZ() * 0.05);
    	}
    }
    
    public void driveTank(double leftValue, double rightValue) {
    	drive.tankDrive(leftValue, rightValue);
    }
    
    public void driveArcade(double moveValue, double rotateValue) {
    	drive.arcadeDrive(moveValue, rotateValue);
    }
}
