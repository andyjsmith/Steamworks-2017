
package org.usfirst.frc.team5546.robot;

import org.opencv.core.Mat;
import org.usfirst.frc.team5546.robot.commands.auto.CenterGearAuto;
import org.usfirst.frc.team5546.robot.commands.auto.DriveToBoilerAuto;
import org.usfirst.frc.team5546.robot.commands.auto.GearAutoGroup;
import org.usfirst.frc.team5546.robot.commands.auto.LeftGearAuto;
import org.usfirst.frc.team5546.robot.commands.auto.TombOfTheUnknownSoldier;
import org.usfirst.frc.team5546.robot.commands.compressor.StartCompressor;
import org.usfirst.frc.team5546.robot.commands.compressor.StopCompressor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.CenterToTape;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveStraight;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.subsystems.Climber;
import org.usfirst.frc.team5546.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5546.robot.subsystems.GearGrabber;
import org.usfirst.frc.team5546.robot.subsystems.Intake;
import org.usfirst.frc.team5546.robot.subsystems.PneumaticCompressor;
import org.usfirst.frc.team5546.robot.subsystems.Shooter;
import org.usfirst.frc.team5546.robot.subsystems.ShooterFeeder;
import org.usfirst.frc.team5546.robot.subsystems.Vision;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Vision vision = new Vision();
	public static final Shooter shooter = new Shooter();
	public static final Intake intake = new Intake();
	public static final PneumaticCompressor compressor = new PneumaticCompressor();
	public static final GearGrabber gearGrabber = new GearGrabber();
	public static final ShooterFeeder feeder = new ShooterFeeder();
	public static final Climber climber = new Climber();
	public static OI oi;

	public static Preferences prefs;

	public static CameraServer cameraServer;
	public static UsbCamera camera, camera2;
	
	public static boolean gearCamera = false;

	VictorSP tempMotor;
	
	AnalogInput pressureSensor;
	PowerDistributionPanel pdp;
	DriverStation driverStation;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		prefs = Preferences.getInstance();
		driverStation = DriverStation.getInstance();
		pdp = new PowerDistributionPanel();
		
		// Auto modes
		chooser.addDefault("Gear Middle", new GearAutoGroup());
		chooser.addObject("Rotate 90deg", new Rotate(90));
		chooser.addObject("Drive for 3 feet", new DriveStraight(6));
		chooser.addObject("Tomb of the Unknown Soldier", new TombOfTheUnknownSoldier());
		chooser.addObject("CenterToTape", new CenterToTape());
		chooser.addObject("LeftGearAuto", new LeftGearAuto());
		chooser.addObject("Boiler", new DriveToBoilerAuto());
		chooser.addObject("CenterGearAuto", new CenterGearAuto());

		SmartDashboard.putData("Auto", chooser);

		pressureSensor = new AnalogInput(1);

		// Camera
		Thread cameraThread = new Thread(() -> {
			boolean drivingForward = false;

			UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture(0);
			cameraForward.setResolution(320, 240);
			cameraForward.setFPS(20);
			UsbCamera cameraReverse = CameraServer.getInstance().startAutomaticCapture(1);
			cameraReverse.setResolution(320, 240);
			cameraReverse.setFPS(20);
			UsbCamera cameraGear = CameraServer.getInstance().startAutomaticCapture(2);
			cameraGear.setResolution(320, 240);
			cameraGear.setFPS(20);

			CvSink cvSinkForward = CameraServer.getInstance().getVideo(cameraForward);
			CvSink cvSinkReverse = CameraServer.getInstance().getVideo(cameraReverse);
			CvSink cvSinkGear = CameraServer.getInstance().getVideo(cameraGear);
			CvSource outputStream = CameraServer.getInstance().putVideo("Switcher", 320, 240);

			Mat image = new Mat();

			while (!Thread.interrupted()) {

				if (oi.switchDirectionForwardBtn.get()) {
					drivingForward = true;
				} else if (oi.switchDirectionReverseBtn.get()) {
					drivingForward = false;
				}

				if (gearCamera) {
					cvSinkReverse.setEnabled(false);
					cvSinkForward.setEnabled(false);
					cvSinkGear.setEnabled(true);
					cvSinkGear.grabFrame(image);
				} else if (drivingForward) {
					cvSinkReverse.setEnabled(false);
					cvSinkGear.setEnabled(false);
					cvSinkForward.setEnabled(true);
					cvSinkForward.grabFrame(image);
				} else {
					cvSinkForward.setEnabled(false);
					cvSinkGear.setEnabled(false);
					cvSinkReverse.setEnabled(true);
					cvSinkReverse.grabFrame(image);
				}

				outputStream.putFrame(image);
			}

		});
		cameraThread.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		SmartDashboard.putData("Scheduler", Scheduler.getInstance());
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("Encoder distance",
		//		driveTrain.encoderLeft.getDistance() / driveTrain.DISTANCE_PER_FOOT);
		SmartDashboard.putNumber("Pressure",
				Math.floor((pressureSensor.getAverageVoltage() - 0.485) / 2.2518 * 120));
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();

		SmartDashboard.putData("Scheduler", Scheduler.getInstance());
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Pressure",
				Math.floor((pressureSensor.getAverageVoltage() - 0.485) / 2.2518 * 120));
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		SmartDashboard.putData("Scheduler", Scheduler.getInstance());

		if (oi.compressorBtn.get()) {
			new StopCompressor();
		} else {
			new StartCompressor();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		SmartDashboard.putNumber("Pressure",
				Math.floor((pressureSensor.getAverageVoltage() - 0.485) / 2.2518 * 120));
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
