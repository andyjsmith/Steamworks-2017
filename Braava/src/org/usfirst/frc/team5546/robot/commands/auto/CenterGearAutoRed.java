package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveFor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.Grab;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the center of the airship and shooting high goals
 */
public class CenterGearAutoRed extends CommandGroup {

    public CenterGearAutoRed() {
		addSequential(new Grab());
		addSequential(new GearAutoGroup());
		addSequential(new Rotate(-85));
		addSequential(new DriveFor(-2, 0.5));
		addSequential(new Rotate(20));
		addSequential(new DriveToBoilerAuto());    		        
    }
}
