package org.usfirst.frc.team5546.robot.commands.shooter;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Keeps the ball shooter at a constant speed based on the PDP voltage
 */
public class KeepShooterSpeed extends Command {

    public KeepShooterSpeed() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Scales the speed based on a proportion of ideal voltage over actual voltage
    	Robot.shooter.talon.set(0.59 * (12.5 / Robot.pdp.getVoltage()));
//    	Robot.shooter.talon.enable();
//    	Robot.shooter.talon.set(Shooter.IDEAL_SPEED * (12.5 / Robot.pdp.getVoltage()));
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
