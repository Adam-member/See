package org.usfirst.frc.team2557.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision_sub extends Subsystem {
	private double widths[];;
	private NetworkTable table;
	private double heights[];
	
	private double areas[];
	
	private double centerXs[];
	private double centerYs[];
	
	public void updateNetworkTables(){
	table = NetworkTable.getTable("GRIP/myContoursReport");
	}
public void initArea(){



double[] defaultValue = new double[0];
while(true){
	areas = table.getNumberArray("area", defaultValue);
	SmartDashboard.putString("areas", "areas: ");
	for(double area: areas){
		SmartDashboard.putNumber("area", area);
		}
}
}
public void initHeight(){



double[] defaultValue = new double[0];
while(true){
	heights = table.getNumberArray("height", defaultValue);
	SmartDashboard.putString("heights", "heights: ");
	for(double height: heights){
		SmartDashboard.putNumber("height", height);
		}
}
}
public void initWidth(){
	double[] defaultValue = new double[0];
	while(true){
		widths = table.getNumberArray("width", defaultValue);
		SmartDashboard.putString("widths", "widths: ");
		for(double width: widths){
			SmartDashboard.putNumber("width", width);
		}
	}
}
public void initCenterX(){
	double[] defaultValue = new double[0];
	while(true){
		heights = table.getNumberArray("centerX", defaultValue);
		SmartDashboard.putString("centerXs", "centerXs: ");
		for(double centerX: centerXs){
			SmartDashboard.putNumber("centerX", centerX);
		}
	}
}
public void initCenterY(){
	double[] defaultValue = new double[0];
	while(true){
		heights = table.getNumberArray("centerY", defaultValue);
		SmartDashboard.putString("centerYs", "centerYs: ");
		for(double centerY: centerYs){
			SmartDashboard.putNumber("centerY", centerY);
		}
	}
}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

