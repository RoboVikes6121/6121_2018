package org.usfirst.frc.team6121.robot.commands;

import org.usfirst.frc.team6121.robot.Robot;
import org.usfirst.frc.team6121.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class DriveStraight extends Command {
	private double move;
	private double curve;
	private double time;

   public DriveStraight(double m, double c, double t) {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.driveSubsystem);
   	move = m;
	curve = c;
	time = t;
   }

   // Called just before this Command runs the first time
   protected void initialize() {
   	setTimeout(time);
   	RobotMap.gyro.reset();
   }

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
   	Robot.driveSubsystem.driveStraight(move);
   }

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
       return isTimedOut();
   }

   // Called once after isFinished returns true
   protected void end() {
   	Robot.driveSubsystem.drive(0, 0);
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   	end();
   }
}