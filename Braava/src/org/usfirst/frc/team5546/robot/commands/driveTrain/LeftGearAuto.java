package org.usfirst.frc.team5546.robot.commands.driveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the left side of the airship
 */
public class LeftGearAuto extends CommandGroup {

    public LeftGearAuto() {
    	addSequential(new DriveStraight(5.6));
    	addSequential(new Rotate(55));
    	addSequential(new GearAutoGroup());
    }
}
