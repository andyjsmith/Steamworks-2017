package org.usfirst.frc.team5546.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RunShooter extends CommandGroup {

    public RunShooter() {
        addParallel(new StartFeeder());
        addParallel(new KeepShooterSpeed());
    }
}
