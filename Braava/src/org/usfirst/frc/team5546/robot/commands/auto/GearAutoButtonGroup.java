package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveFor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.GearAuto;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PickUpGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PlaceGear;
import org.usfirst.frc.team5546.robot.commands.lights.DisableVisionLight;
import org.usfirst.frc.team5546.robot.commands.lights.EnableVisionLight;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Driver station button for placing a gear on the center pin of the airship
 */
public class GearAutoButtonGroup extends CommandGroup {

    public GearAutoButtonGroup() {
    	addSequential(new EnableVisionLight());	// turn on the light
    	addSequential(new WaitCommand(0.3));
    	addSequential(new GearAuto(0.65)); 			// run the vision code
    	//addSequential(new DriveUntilWall(0.3));	// drive with the ultrasonic sensor for the remaining distance
    	addSequential(new DriveFor(0.3, 0.5));
    	addSequential(new DisableVisionLight());	// turn off the light
    	addSequential(new PlaceGear());			// place the gear
    	addSequential(new WaitCommand(0.3));	// wait for the piston to fully extend
    	addSequential(new DriveFor(-2, 0.5));	// back up a little bit
    	addSequential(new PickUpGear());		// bring the gear mech back up
    }
}
