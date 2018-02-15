package org.usfirst.frc.team6121.robot.subsystems;

import org.usfirst.frc.team6121.robot.OI;
import org.usfirst.frc.team6121.robot.RobotMap;
import org.usfirst.frc.team6121.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class DriveSubsystem extends Subsystem {
	
	/** Constant for driving straight **/
	private static final double Kp = 0.05;
	/** Drive straight constant **/
	private static final double Kdriveturn = 0.35;
	
	 public void arcadeDrive(Joystick stick) {
		 double angle = RobotMap.gyro.getAngle();
		 double forward = (OI.driverJoystick.getRawAxis(RobotMap.Y_AXIS)) * (OI.driverJoystick.getRawAxis(RobotMap.R_TRIGGER) + .75);
	    	double turn = OI.driverJoystick.getRawAxis(RobotMap.X_AXIS);
	    	RobotMap.driveTrain.arcadeDrive(turn, forward);
	 }
	 
	 public void driveStraight(double speed) {
	    	double angle = RobotMap.gyro.getAngle();
	    	drive(speed, angle * Kp);
	    	Timer.delay(0.004);
	 }
	 
	 public void Turn(double curve) {
	    	double angle = RobotMap.gyro.getAngle();
	    	drive(angle * Kdriveturn, curve);
	    	Timer.delay(0.004);
	 }

   // Put methods for controlling this subsystem
   // here. Call these from Commands.z

   public void initDefaultCommand() {
   	
   	setDefaultCommand(new ArcadeDrive());
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
   
   public void drive(double m, double c) {
   	RobotMap.driveTrain.arcadeDrive(m,  c);
   }
}

