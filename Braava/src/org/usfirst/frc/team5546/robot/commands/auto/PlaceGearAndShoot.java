package org.usfirst.frc.team5546.robot.commands.auto;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceGearAndShoot extends Command {
	
	boolean finished = false;

	public PlaceGearAndShoot() {
	}

	protected void initialize() {
	}
	
	protected void execute() {
		switch (Robot.positionChooser.getSelected()) {
		case BOILER:
			new BoilerSideGearAuto();
			break;
		case LOADINGSTATION:
			new LoadingStationSideGearAuto();
			break;
		case CENTER:
			new CenterGearAuto();
			break;
		}
		finished = true;
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}
}
