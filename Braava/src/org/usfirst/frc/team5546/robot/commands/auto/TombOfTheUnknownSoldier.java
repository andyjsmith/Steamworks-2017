package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.Robot;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TombOfTheUnknownSoldier extends CommandGroup {

    public TombOfTheUnknownSoldier() {
    	for (int i = 0; i < 10; i++) {
    		new DriveStraight(0).initialize();
			addSequential(new DriveStraight(5));
			addSequential(new Rotate(180));
			Robot.driveTrain.imu.reset();
			addSequential(new WaitCommand(0.5));
		}
    }
}
