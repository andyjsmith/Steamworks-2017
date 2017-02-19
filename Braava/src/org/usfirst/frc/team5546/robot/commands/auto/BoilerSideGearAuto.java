package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;

import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the boiler side of the airship and shooting high goals
 */
public class BoilerSideGearAuto extends CommandGroup {

    public BoilerSideGearAuto() {
    	if (Robot.driverStation.getAlliance() == Alliance.Blue) {
	    	addSequential(new DriveStraight(6.3));	// drive using the gyro for an amount of feet
	    	addSequential(new Rotate(55));			// rotate to face the gear
	    	addSequential(new GearAutoGroup());		// run the normal vision code and place the gear
			addSequential(new Rotate(-15));			// face the boiler
		} else {
			addSequential(new DriveStraight(6.3));	// drive using the gyro for an amount of feet
			addSequential(new Rotate(-55));			// rotate to face the gear
			addSequential(new GearAutoGroup());		// run the normal vision code and place the gear
			addSequential(new Rotate(15));			// face the boiler
		}
		addSequential(new DriveToBoilerAuto());
	}
}
