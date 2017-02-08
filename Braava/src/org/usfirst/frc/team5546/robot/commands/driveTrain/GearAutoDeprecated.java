package org.usfirst.frc.team5546.robot.commands.driveTrain;

import java.util.ArrayList;

import org.usfirst.frc.team5546.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearAutoDeprecated extends Command {
	
	NetworkTable visionTable;
	double[] x, y, width, height;
	
	ArrayList<Double> historyXLeft = new ArrayList<Double>();
	ArrayList<Double> historyXRight = new ArrayList<Double>();
	ArrayList<Double> historyAreaLeft = new ArrayList<Double>();
	ArrayList<Double> historyAreaRight = new ArrayList<Double>();
	
	double[] avgAreas = {0, 0}, avgX = {0, 0};
	
	double distance = 0;
	
	int iterations = 0;
	
	final int IMAGE_WIDTH = 320;
	final int IMAGE_MIDPOINT = IMAGE_WIDTH / 2;

    public GearAutoDeprecated(double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.distance = distance;
        visionTable = NetworkTable.getTable("vision/gear");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    double[] tempVal = {0, 0, 0, 0};
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	iterations++;
    	if (!updateValues()) {
    		return;
    	}
    	
    	double areaLeft = 0, areaRight = 0;
    	areaLeft = width[0] * height[0];
    	areaRight = width[1] * height[1];
    	
    	if (iterations % 10 == 0 && historyAreaLeft.size() >= 5) {
    		processHistory();
    		double targetMidpoint = (avgX[1] - avgX[0]) / 2;
    		double rotation = (IMAGE_MIDPOINT - targetMidpoint) / IMAGE_MIDPOINT;
    		//Robot.driveTrain.driveArcade(0.4, rotation);
    		SmartDashboard.putNumber("Drive Rotation", rotation);
    		
    		historyAreaLeft.clear();
    		historyAreaRight.clear();
    		historyXLeft.clear();
    		historyXRight.clear();
    	} else {
    		historyAreaLeft.add(areaLeft);
    		historyAreaRight.add(areaRight);
    		historyXLeft.add(x[0]);
    		historyXRight.add(x[1]);
    	}
    	
    	//SmartDashboard.putNumber("# of Objects", visionTable.getNumberArray("x", new double[0]).length);
    	SmartDashboard.putNumber("area", x[1]*y[1]);
    	//SmartDashboard.putString("Object Areas", "" + areaList[0] + ", " + areaList[1]);
    	SmartDashboard.putString("Average Areas", "" + tempVal[0] + ", " + tempVal[1]);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
    
    void processHistory() {    	
    	double[] areas = {0, 0}, sumX = {0, 0};
    	int length = historyAreaLeft.size();
    	
    	for (int i = 0; i < length; i++) {
    		areas[0] += historyAreaLeft.get(i);
    		areas[1] += historyAreaRight.get(i);
    		sumX[0] += historyXLeft.get(i);
    		sumX[1] += historyXRight.get(i);
		}
    	
    	avgAreas[0] = areas[0] / length;
    	avgAreas[1] = areas[1] / length;
    	avgX[0] = sumX[0] / length;
    	avgX[1] = sumX[1] / length;
    }
}
