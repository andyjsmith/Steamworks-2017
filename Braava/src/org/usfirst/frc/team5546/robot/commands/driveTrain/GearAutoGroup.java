package org.usfirst.frc.team5546.robot.commands.driveTrain;

import org.usfirst.frc.team5546.robot.commands.gearGrabber.LowerGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.Release;
import org.usfirst.frc.team5546.robot.commands.vision.StartVision;
import org.usfirst.frc.team5546.robot.commands.vision.StopVision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GearAutoGroup extends CommandGroup {

    public GearAutoGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new StartVision());
    	addSequential(new GearAuto());
    	addSequential(new Release());
    	addSequential(new WaitCommand(0.7));
    	addSequential(new LowerGear());
    	addSequential(new DriveFor(-1));
    	addParallel(new StopVision());
    }
}
