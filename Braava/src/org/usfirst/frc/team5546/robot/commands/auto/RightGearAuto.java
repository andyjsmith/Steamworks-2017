package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the right side of the airship
 */
public class RightGearAuto extends CommandGroup {

    public RightGearAuto() {
    	addSequential(new DriveStraight(5.6));	// drive using the gyro for an amount of feet
    	addSequential(new Rotate(-55));			// rotate to face the gear
    	addSequential(new GearAutoGroup());		// run the normal vision code and place the gear
    }
}