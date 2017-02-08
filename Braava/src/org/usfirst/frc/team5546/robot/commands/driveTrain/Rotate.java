package org.usfirst.frc.team5546.robot.commands.driveTrain;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Rotate extends Command {

	double setpoint = 0;
	double offset = 3.0;
	
    public Rotate(double setpoint) {
        // Use requires() here to declare subsystem dependencies
    	this.setpoint = setpoint;
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.enable();
    	Robot.driveTrain.imu.reset();
    	Robot.driveTrain.rotate = true;
    	
    	Robot.driveTrain.getPIDController().setPID(0.10, 0, 0.3);
    	Robot.driveTrain.setAbsoluteTolerance(offset);
    	Robot.driveTrain.setSetpointRelative(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("setpoint", Robot.driveTrain.getSetpoint());
    	SmartDashboard.putNumber("imu", Robot.driveTrain.imu.getAngleZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.disable();
    }
}
