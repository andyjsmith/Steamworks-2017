package org.usfirst.frc.team5546.robot.commands.driveTrain;

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
    	addSequential(new StartGearVision());
    	addSequential(new GearAuto());
    	addSequential(new DriveUntilWall(0.3));
    	addSequential(new StopGearVision());
    	addSequential(new PlaceGear());
    	addSequential(new WaitCommand(0.3));
    	addSequential(new DriveFor(-2, 0.5));
    	addSequential(new PickUpGear());
    }
}
