package org.usfirst.frc.team5546.robot.commands.gearGrabber;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grab extends Command {

    public Grab() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearGrabber.grabGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
