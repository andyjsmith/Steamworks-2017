package org.usfirst.frc.team5546.robot.commands.gearGrabber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Place gear routine. Opens the extender and pushes the mechanism down.
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
        addSequential(new Release());
        addSequential(new WaitCommand(0.5));
        addSequential(new LowerGear());
    }
}
