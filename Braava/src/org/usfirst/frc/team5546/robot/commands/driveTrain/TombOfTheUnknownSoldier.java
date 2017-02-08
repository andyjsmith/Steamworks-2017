package org.usfirst.frc.team5546.robot.commands.driveTrain;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TombOfTheUnknownSoldier extends CommandGroup {

    public TombOfTheUnknownSoldier() {
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
    	
    	for (int i = 0; i < 10; i++) {
    		new DriveStraight(0).initialize();
			addSequential(new DriveStraight(5));
			addSequential(new Rotate(180));
			Robot.driveTrain.imu.reset();
			addSequential(new WaitCommand(0.5));
		}
    }
}
