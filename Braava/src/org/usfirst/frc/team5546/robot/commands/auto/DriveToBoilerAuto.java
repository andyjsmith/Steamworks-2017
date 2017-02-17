package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveToBoiler;
import org.usfirst.frc.team5546.robot.commands.vision.StartHighGoalVision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToBoilerAuto extends CommandGroup {

    public DriveToBoilerAuto() {
        addSequential(new StartHighGoalVision());
        addSequential(new DriveToBoiler());
    }
}
