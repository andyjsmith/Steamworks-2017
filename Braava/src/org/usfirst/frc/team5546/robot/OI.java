package org.usfirst.frc.team5546.robot;

import org.usfirst.frc.team5546.robot.commands.auto.DriveToBoilerAuto;
import org.usfirst.frc.team5546.robot.commands.cameras.DisableGearCamera;
import org.usfirst.frc.team5546.robot.commands.cameras.EnableGearCamera;
import org.usfirst.frc.team5546.robot.commands.climber.Climb;
import org.usfirst.frc.team5546.robot.commands.climber.StopClimb;
import org.usfirst.frc.team5546.robot.commands.compressor.StartCompressor;
import org.usfirst.frc.team5546.robot.commands.compressor.StopCompressor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Drive;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveInverse;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.CloseGearSlot;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PickUpGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PlaceGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PrepareGearSlot;
import org.usfirst.frc.team5546.robot.commands.intake.StartIntake;
import org.usfirst.frc.team5546.robot.commands.intake.StopIntake;
import org.usfirst.frc.team5546.robot.commands.shooter.DisableShooter;
import org.usfirst.frc.team5546.robot.commands.shooter.RunShooter;
import org.usfirst.frc.team5546.robot.commands.vision.StartGearVision;
import org.usfirst.frc.team5546.robot.commands.vision.StopGearVision;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Joysticks
	public XboxController xbox = new XboxController(0);
	public Joystick stickLeft = new Joystick(1);
	public Joystick stickRight = new Joystick(2);
	public Joystick launchpad = new Joystick(3);
	
	// Switching drive directions
	public boolean inverseDrive = false;
	public Button switchDirectionForwardBtn = new JoystickButton(stickRight, 2);
	public Button switchDirectionReverseBtn = new JoystickButton(stickRight, 3);
	
	public Button compressorBtn = new JoystickButton(launchpad, 3);
	public Button shooterFeederBtn = new JoystickButton(launchpad, 2);
	
	public Button gearPickUpBtn = new JoystickButton(stickRight, 1);

	public Button gearSlotBtn = new JoystickButton(stickLeft, 1);
	
	public Button intakeBtn = new JoystickButton(launchpad, 4);
	
	public Button climberBtn = new JoystickButton(launchpad, 7);
	
	public Button gearLightBtn = new JoystickButton(stickLeft, 7);
	public Button highgoalLightBtn = new JoystickButton(stickLeft, 8);
	
	public Button boilerBtn = new JoystickButton(stickRight, 9);
	
	public OI() {
		switchDirectionForwardBtn.whenPressed(new Drive());
		switchDirectionReverseBtn.whenPressed(new DriveInverse());
		
		compressorBtn.whenPressed(new StopCompressor());
		compressorBtn.whenReleased(new StartCompressor());
		
		shooterFeederBtn.whenReleased(new RunShooter());
		shooterFeederBtn.whenPressed(new DisableShooter());

		gearPickUpBtn.whenPressed(new PlaceGear());
		gearPickUpBtn.whenReleased(new PickUpGear());
		
		gearPickUpBtn.whenPressed(new EnableGearCamera());
		gearPickUpBtn.whenReleased(new DisableGearCamera());
		
		gearSlotBtn.whenPressed(new PrepareGearSlot());
		gearSlotBtn.whenReleased(new CloseGearSlot());
		
		intakeBtn.whenReleased(new StartIntake());
		intakeBtn.whenPressed(new StopIntake());
		
		gearLightBtn.whenPressed(new StartGearVision());
		highgoalLightBtn.whenPressed(new StopGearVision());
		
		boilerBtn.whenPressed(new DriveToBoilerAuto());
		
		climberBtn.whenPressed(new Climb());
		climberBtn.whenReleased(new StopClimb());
	}
}
