package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearAndShoot extends CommandGroup {

    public PlaceGearAndShoot() {
        switch (Robot.positionChooser.getSelected()) {
		case BOILER:
			addSequential(new BoilerSideGearAuto());
			break;
		case LOADINGSTATION:
			addSequential(new LoadingStationSideGearAuto());
			break;
		case CENTER:
			addSequential(new CenterGearAuto());
			break;
		}
    }
}
