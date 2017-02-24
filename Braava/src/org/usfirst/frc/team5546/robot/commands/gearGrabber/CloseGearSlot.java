package org.usfirst.frc.team5546.robot.commands.gearGrabber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CloseGearSlot extends CommandGroup {

    public CloseGearSlot() {
        addSequential(new RetractChute());
        addSequential(new WaitCommand(0.8));
        addSequential(new Grab());
    }
}
