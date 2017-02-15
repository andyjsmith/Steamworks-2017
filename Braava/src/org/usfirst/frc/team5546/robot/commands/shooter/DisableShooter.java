package org.usfirst.frc.team5546.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DisableShooter extends CommandGroup {

    public DisableShooter() {
        addParallel(new StopShooter());
        addParallel(new StopFeeder());
    }
}
