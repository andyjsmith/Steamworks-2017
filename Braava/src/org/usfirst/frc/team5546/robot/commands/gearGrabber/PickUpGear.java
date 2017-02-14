package org.usfirst.frc.team5546.robot.commands.gearGrabber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Pick up gear routine. Closes the extender and pulls the mechanism up.
 */
public class PickUpGear extends CommandGroup {

    public PickUpGear() {
    	addSequential(new Grab());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new LiftGear());
    }
}
