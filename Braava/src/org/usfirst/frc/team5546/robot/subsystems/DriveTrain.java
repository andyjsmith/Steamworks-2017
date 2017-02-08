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

    public DriveTrain() {
    	super(4, 0.1, 0);
    	setAbsoluteTolerance(20);
    	imu = new ADIS16448_IMU();    	
    	drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    	drive.setSafetyEnabled(false);
    	encoderLeft = new Encoder(0, 1);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    protected double returnPIDInput() {
        if (rotate) {
        	return imu.getAngleZ();
        } else {
        	return encoderLeft.getDistance();
        }
    }

    protected void usePIDOutput(double output) {
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
