package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveFor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveUntilWall;
import org.usfirst.frc.team5546.robot.commands.driveTrain.GearAuto;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PickUpGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PlaceGear;
import org.usfirst.frc.team5546.robot.commands.vision.StartGearVision;
import org.usfirst.frc.team5546.robot.commands.vision.StopGearVision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous mode for placing a gear on the center pin of the airship
 */
public class GearAutoGroup extends CommandGroup {

    public GearAutoGroup() {
    	addSequential(new StartGearVision());	// turn on the light
    	addSequential(new GearAuto()); 			// run the vision code
    	addSequential(new DriveUntilWall(0.3));	// drive with the ultrasonic sensor for the remaining distance
    	addSequential(new StopGearVision());	// turn off the light
    	addSequential(new PlaceGear());			// place the gear
    	addSequential(new WaitCommand(0.3));	// wait for the piston to fully extend
    	addSequential(new DriveFor(-2, 0.5));	// back up a little bit
    	addSequential(new PickUpGear());		// bring the gear mech back up
    }
}
