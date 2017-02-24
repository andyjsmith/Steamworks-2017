package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveInverse;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveToBoiler;
import org.usfirst.frc.team5546.robot.commands.shooter.KeepShooterSpeed;
import org.usfirst.frc.team5546.robot.commands.shooter.StartFeeder;
import org.usfirst.frc.team5546.robot.commands.vision.StartHighGoalVision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DriveToBoilerAuto extends CommandGroup {

    public DriveToBoilerAuto() {
        addSequential(new StartHighGoalVision());
        addSequential(new WaitCommand(0.3));
        addParallel(new KeepShooterSpeed());
        addSequential(new DriveToBoiler());
        addParallel(new StartFeeder());
        addSequential(new DriveInverse());
    }
}
