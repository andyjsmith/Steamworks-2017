package org.usfirst.frc.team5546.robot.commands.driveTrain;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveToBoiler extends Command {

	NetworkTable visionTable;
	double[] x, y, width, height;

	final int IMAGE_WIDTH = 320;
	final int IMAGE_MIDPOINT = 160;
	
	final double IDEAL_AREA = 1350; //1250
	
	boolean finished = false;

	public DriveToBoiler() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		visionTable = NetworkTable.getTable("vision/highgoal");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		finished = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double[] array = visionTable.getNumberArray("x", new double[2]);
		if (array.length == 2 && !finished) {			
			double midpoint = (array[1] - array[0]) / 2 + array[0];
			
			double rotation = (midpoint - IMAGE_MIDPOINT) / 1000 * -1;
			
			Robot.driveTrain.driveArcade(-0.5, Math.cbrt(rotation));
			
			double area = (visionTable.getNumberArray("width", new double[2])[0] + 
					visionTable.getNumberArray("width", new double[2])[1]) * 
					(visionTable.getNumberArray("height", new double[2])[0] + 
					visionTable.getNumberArray("height", new double[2])[1]);
			
			if (area >= IDEAL_AREA) { //6900.0
				finished = true;
				Robot.driveTrain.driveArcade(0, 0);
			}
			
			SmartDashboard.putNumber("area", area);
			SmartDashboard.putNumber("midpoint", midpoint);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	boolean updateValues() {
		x = visionTable.getNumberArray("x", new double[2]);
		y = visionTable.getNumberArray("y", new double[2]);
		width = visionTable.getNumberArray("width", new double[2]);
		height = visionTable.getNumberArray("height", new double[2]);

		return visionTable.getNumberArray("x", new double[0]).length == 2;
	}
}