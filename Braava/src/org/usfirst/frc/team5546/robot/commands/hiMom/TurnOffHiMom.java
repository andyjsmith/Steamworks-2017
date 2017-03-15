package org.usfirst.frc.team5546.robot.commands.hiMom;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns off the "Hi Mom" wire sign
 */
public class TurnOffHiMom extends Command {

    public TurnOffHiMom() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.hiMom);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.hiMom.turnOffMom();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
