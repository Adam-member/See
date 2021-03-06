
package org.usfirst.frc.team2557.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2557.robot.subsystems.Chassis_sub;
import org.usfirst.frc.team2557.robot.subsystems.Climber_sub;
import org.usfirst.frc.team2557.robot.subsystems.Gear_sub;
import org.usfirst.frc.team2557.robot.subsystems.Intake_sub;
import org.usfirst.frc.team2557.robot.subsystems.Shooter_sub;
import org.usfirst.frc.team2557.robot.subsystems.Vision_sub;
import org.usfirst.frc.team2557.robot.commands.VisionArea_cmd;
import org.usfirst.frc.team2557.robot.commands.VisionCenterX_cmd;
import org.usfirst.frc.team2557.robot.commands.VisionCenterY_cmd;
import org.usfirst.frc.team2557.robot.commands.VisionHeight_cmd;
import org.usfirst.frc.team2557.robot.commands.VisionWidth_cmd;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Chassis_sub chassis;
	public static Vision_sub vision;
	public static Gear_sub gear;
	public static Shooter_sub shooter;
	public static Climber_sub climber;
	public static Intake_sub intake;

	Command autonomousCommand;
	Command VisionArea_cmd;
	Command VisionCenterX_cmd;
	Command VisionCenterY_cmd;
	Command VisionHeight_cmd;
	Command VisionWidth_cmd;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		chassis = new Chassis_sub();
		vision = new Vision_sub();
		gear = new Gear_sub();
		shooter = new Shooter_sub();
		intake = new Intake_sub();
		
		VisionArea_cmd = new VisionArea_cmd();
		VisionCenterX_cmd = new VisionCenterX_cmd();
		VisionCenterY_cmd = new VisionCenterY_cmd();
		VisionHeight_cmd = new VisionHeight_cmd();
		VisionWidth_cmd = new VisionWidth_cmd();
		
		oi = new OI(); //"oi = new OI();" must be initialized after all subsystems and commands
		oi.init();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		VisionArea_cmd.start();
		VisionCenterX_cmd.start();
		VisionCenterY_cmd.start();
		VisionHeight_cmd.start();
		VisionWidth_cmd.start();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
