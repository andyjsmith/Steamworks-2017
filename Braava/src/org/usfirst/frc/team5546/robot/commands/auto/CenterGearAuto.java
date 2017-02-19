package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveFor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.Grab;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterGearAuto extends CommandGroup {

    public CenterGearAuto() {
        addSequential(new Grab());
        addSequential(new GearAutoGroup());
        addSequential(new Rotate(90));
        addSequential(new DriveFor(-4, 0.5));
        addSequential(new Rotate(-20));
        addSequential(new DriveToBoilerAuto());
        
    }
}
