package org.usfirst.frc.team5546.robot.commands.gearGrabber;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrepareGearSlot extends CommandGroup {

    public PrepareGearSlot() {
        addSequential(new ExtendChute());
        addSequential(new Release());
    }
}
