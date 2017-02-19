package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveFor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.Grab;

import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous mode for placing a gear on the center of the airship and shooting high goals
 */
public class CenterGearAuto extends CommandGroup {

    public CenterGearAuto() {
    	if (Robot.driverStation.getAlliance() == Alliance.Blue) {
	        addSequential(new Grab());
	        addSequential(new GearAutoGroup());
	        addSequential(new Rotate(90));
	        addSequential(new DriveFor(-4, 0.5));
	        addSequential(new Rotate(-20));
	        addSequential(new DriveToBoilerAuto());
    	} else {
    		addSequential(new Grab());
    		addSequential(new GearAutoGroup());
    		addSequential(new Rotate(-90));
    		addSequential(new DriveFor(-4, 0.5));
    		addSequential(new Rotate(20));
    		addSequential(new DriveToBoilerAuto());    		
    	}
        
    }
}
