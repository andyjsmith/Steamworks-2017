package org.usfirst.frc.team5546.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RunShooter extends CommandGroup {

    public RunShooter() {
    	addParallel(new KeepShooterSpeed());
    	addSequential(new WaitCommand(3));
        addParallel(new StartFeeder());
    }
}
