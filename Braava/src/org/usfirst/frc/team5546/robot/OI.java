package org.usfirst.frc.team5546.robot;

import org.usfirst.frc.team5546.robot.commands.auto.DriveToBoilerAuto;
import org.usfirst.frc.team5546.robot.commands.auto.GearAutoButtonGroup;
import org.usfirst.frc.team5546.robot.commands.cameras.DisableGearCamera;
import org.usfirst.frc.team5546.robot.commands.cameras.EnableGearCamera;
import org.usfirst.frc.team5546.robot.commands.climber.Climb;
import org.usfirst.frc.team5546.robot.commands.climber.StopClimb;
import org.usfirst.frc.team5546.robot.commands.compressor.StartCompressor;
import org.usfirst.frc.team5546.robot.commands.compressor.StopCompressor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Drive;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveInverse;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.CloseGearSlot;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.LiftGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PickUpGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PlaceGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PrepareGearSlot;
import org.usfirst.frc.team5546.robot.commands.intake.StartIntake;
import org.usfirst.frc.team5546.robot.commands.intake.StopIntake;
import org.usfirst.frc.team5546.robot.commands.lights.ToggleLights;
import org.usfirst.frc.team5546.robot.commands.shooter.DisableShooter;
import org.usfirst.frc.team5546.robot.commands.shooter.RunShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Joysticks
	public Joystick stickLeft = new Joystick(0);
	public Joystick stickRight = new Joystick(1);
	public Joystick launchpad = new Joystick(2);
	
	// Switching drive directions
	public boolean inverseDrive = false;
	public Button switchDirectionForwardBtn = new JoystickButton(stickRight, 2);
	public Button switchDirectionReverseBtn = new JoystickButton(stickLeft, 2);
	
	public Button compressorBtn = new JoystickButton(launchpad, 3);
	public Button shooterFeederBtn = new JoystickButton(launchpad, 2);
	public Button intakeBtn = new JoystickButton(launchpad, 1);
	public Button climberBtn = new JoystickButton(launchpad, 4);
	
	public Button gearPickUpBtn = new JoystickButton(stickRight, 1);
	public Button gearSlotBtn = new JoystickButton(stickLeft, 1);
	
	public Button placeGearWithoutRetractBtn = new JoystickButton(stickRight, 3);
	
	public Button boilerBtn = new JoystickButton(launchpad, 9);
	public Button gearBtn = new JoystickButton(launchpad, 8);
	
	public Button agitatorFixBtn = new JoystickButton(launchpad, 6);
	
	public Button cancelGearBtn = new JoystickButton(launchpad, 5);
	
	public Button lightBtn = new JoystickButton(launchpad, 7);
	
	public Button gearViewButton = new JoystickButton(stickLeft, 4);
	
	public OI() {
		switchDirectionForwardBtn.whenPressed(new Drive());
		switchDirectionReverseBtn.whenPressed(new DriveInverse());
		
		compressorBtn.whenPressed(new StartCompressor());
		compressorBtn.whenReleased(new StopCompressor());
		
		shooterFeederBtn.whenReleased(new RunShooter());
		shooterFeederBtn.whenPressed(new DisableShooter());

		gearPickUpBtn.whenPressed(new PlaceGear());
		gearPickUpBtn.whenReleased(new PickUpGear());
		
		gearPickUpBtn.whenPressed(new EnableGearCamera());
		gearPickUpBtn.whenReleased(new DisableGearCamera());
		
		placeGearWithoutRetractBtn.whenPressed(new PlaceGear());
		placeGearWithoutRetractBtn.whenReleased(new LiftGear());
		
		gearSlotBtn.whenPressed(new PrepareGearSlot());
		gearSlotBtn.whenReleased(new CloseGearSlot());
		
		intakeBtn.whenReleased(new StartIntake());
		intakeBtn.whenPressed(new StopIntake());
		
		boilerBtn.whenPressed(new DriveToBoilerAuto());
		gearBtn.whenPressed(new GearAutoButtonGroup());
		
		climberBtn.whenPressed(new Climb());
		climberBtn.whenReleased(new StopClimb());
		
		lightBtn.whenPressed(new ToggleLights());
	}
}
