package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.Grab;
import org.usfirst.frc.team5546.robot.commands.lights.EnableVisionLight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the boiler side of the airship and shooting high goals
 */
public class BoilerSideGearAutoRed extends CommandGroup {

    public BoilerSideGearAutoRed() {
    	addSequential(new EnableVisionLight());
    	addSequential(new Grab());
		addSequential(new DriveStraight(6.4));	// drive using the gyro for an amount of feet
		addSequential(new Rotate(-60));			// rotate to face the gear
		addSequential(new GearAutoGroup());		// run the normal vision code and place the gear
		addSequential(new Rotate(25));			// face the boiler
		addSequential(new DriveToBoilerAuto());
	}
}
