package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GeminiDrive_cmd extends Command {


	
	
    public GeminiDrive_cmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.start1.get() && Robot.oi.select1.get()){
    		RobotMap.gemini = false;
    	} else if(Robot.oi.start2.get() && Robot.oi.select2.get()){
    		RobotMap.gemini = true;
    	}
    	
    	if(RobotMap.gemini){
    		Robot.chassis.arcadeDrive_fuel();
    	} else if(RobotMap.gemini == false){
    		Robot.chassis.arcadeDrive_gear();
    	}
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
}
