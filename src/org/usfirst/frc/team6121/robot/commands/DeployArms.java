/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot.commands;

import org.usfirst.frc.team6121.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class DeployArms extends Command {
	private double speed;
	private double time;

   public DeployArms(double s, double t) {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.cubeSubsystem);
   	speed = s;
   	time = t;
   }

   // Called just before this Command runs the first time
   protected void initialize() {
   	setTimeout(time);
   }

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
   	Robot.cubeSubsystem.setArms(speed);
   	
   }

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
       return isTimedOut();
   }

   // Called once after isFinished returns true
   protected void end() {
   	Robot.cubeSubsystem.setArms(0);
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   	end();
   }
}
