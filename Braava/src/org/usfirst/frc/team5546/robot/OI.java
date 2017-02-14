package org.usfirst.frc.team5546.robot;

import org.usfirst.frc.team5546.robot.commands.cameras.DisableGearCamera;
import org.usfirst.frc.team5546.robot.commands.cameras.EnableGearCamera;
import org.usfirst.frc.team5546.robot.commands.compressor.StartCompressor;
import org.usfirst.frc.team5546.robot.commands.compressor.StopCompressor;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Drive;
import org.usfirst.frc.team5546.robot.commands.driveTrain.DriveInverse;
import org.usfirst.frc.team5546.robot.commands.driveTrain.Rotate;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PickUpGear;
import org.usfirst.frc.team5546.robot.commands.gearGrabber.PlaceGear;
import org.usfirst.frc.team5546.robot.commands.shooter.StartFeeder;
import org.usfirst.frc.team5546.robot.commands.shooter.StopFeeder;
import org.usfirst.frc.team5546.robot.commands.vision.StartVision;
import org.usfirst.frc.team5546.robot.commands.vision.StopVision;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public Button switchDirectionForwardBtn = new JoystickButton(stickRight, 1);
	public Button switchDirectionReverseBtn = new JoystickButton(stickLeft, 1);
	
	// Start vision button (turns on light)
	public Button startVision = new JoystickButton(stickRight, 3);
	public Button compressorBtn = new JoystickButton(launchpad, 3);
	public Button shooterFeederBtn = new JoystickButton(launchpad, 2);
	
	public Button gearCameraBtn = new JoystickButton(stickRight, 2);

	public Button gearLiftBtn = new JoystickButton(launchpad, 4);
	
	public OI() {
		switchDirectionForwardBtn.whenPressed(new Drive());
		switchDirectionReverseBtn.whenPressed(new DriveInverse());
		
		startVision.whenPressed(new StopVision());
		startVision.whenReleased(new StartVision());
		
		compressorBtn.whenPressed(new StopCompressor());
		compressorBtn.whenReleased(new StartCompressor());
		
		shooterFeederBtn.whenPressed(new StopFeeder());
		shooterFeederBtn.whenReleased(new StartFeeder());

		gearLiftBtn.whenPressed(new PickUpGear());
		gearLiftBtn.whenReleased(new PlaceGear());
		
		gearCameraBtn.whenPressed(new EnableGearCamera());
		gearCameraBtn.whenReleased(new DisableGearCamera());
		
		SmartDashboard.putData("Rotate", new Rotate(90));
	}
}
