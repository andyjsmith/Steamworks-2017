package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the right side of the airship
 */
public class LoadingStationSideGearAutoBlue extends CommandGroup {

    public LoadingStationSideGearAutoBlue() {
		addSequential(new DriveStraight(6.8));	// drive using the gyro for an amount of feet
		addSequential(new Rotate(-60));			// rotate to face the gear
		addSequential(new GearAutoGroup());		// run the normal vision code and place the gear
    }
}
