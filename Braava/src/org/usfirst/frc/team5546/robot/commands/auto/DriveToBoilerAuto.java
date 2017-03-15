package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveInverse;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveToBoiler;
import org.usfirst.frc.team5546.robot.commands.shooter.KeepShooterSpeed;
import org.usfirst.frc.team5546.robot.commands.shooter.StartFeeder;
import org.usfirst.frc.team5546.robot.commands.vision.StartHighGoalVision;
import org.usfirst.frc.team5546.robot.commands.vision.StopHighGoalVision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Look for the boiler, drive to it, and shoot
 */
public class DriveToBoilerAuto extends CommandGroup {

    public DriveToBoilerAuto() {
        addSequential(new StartHighGoalVision()); // turn on the vision light
        addSequential(new WaitCommand(0.3)); // give the camera time to adjust to the light
        addParallel(new KeepShooterSpeed()); // warm up the shooter
        addSequential(new DriveToBoiler()); // use vision to drive to the boiler
        addParallel(new StartFeeder()); // turn on the shooter and elevator
        addParallel(new StopHighGoalVision()); // turn off the vision light
        addSequential(new DriveInverse()); // let the driver adjust once the shooter has started
    }
}
