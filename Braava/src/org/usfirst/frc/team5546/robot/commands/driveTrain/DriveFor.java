package org.usfirst.frc.team5546.robot.commands.driveTrain;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveFor extends Command {

	double distance = 0;
	
    public DriveFor(double feet, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.distance = feet * Robot.driveTrain.DISTANCE_PER_FOOT;
        Robot.driveTrain.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.rotate = false;
    	//Robot.driveTrain.encoderLeft.reset();
    	Robot.driveTrain.imu.reset();
    	Robot.driveTrain.getPIDController().setPID(4, 0.1, 0);
    	Robot.driveTrain.setSetpointRelative(distance);
    	Robot.driveTrain.setAbsoluteTolerance(100);
    	Robot.driveTrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.onTarget() || Robot.oi.cancelGearBtn.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
