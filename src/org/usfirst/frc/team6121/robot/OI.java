/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot;

import org.usfirst.frc.team6121.robot.commands.DeployRamps;
import org.usfirst.frc.team6121.robot.commands.RampsSolenoidExpand;
import org.usfirst.frc.team6121.robot.commands.RampsSolenoidRetract;
import org.usfirst.frc.team6121.robot.commands.RampsUp;
import org.usfirst.frc.team6121.robot.commands.TransmissionSolenoidExpand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick driverJoystick;
	public static Joystick operatorJoystick;
	
	OI() {
		
		driverJoystick = new Joystick(RobotMap.DRIVER_JOYSTICK);
		operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
		
		Button deployRampsButton = new JoystickButton(operatorJoystick, RobotMap.DEPLOY_RAMP_BUTTON);
		deployRampsButton.whenPressed(new DeployRamps(.5, 5));
		
		Button disarmRampButton = new JoystickButton(operatorJoystick, RobotMap.DISARM_RAMP_BUTTON);
		disarmRampButton.whenPressed(new RampsUp(-.5, 5));
		
		Button launcherArmsUpButton = new JoystickButton(driverJoystick, RobotMap.LAUNCHER_ARMS_UP);
		launcherArmsUpButton.whenPressed(new DeployRamps(.5, 5));
		
		Button launcherArmsDownButton = new JoystickButton(driverJoystick, RobotMap.LAUNCHER_ARMS_DOWN);
		launcherArmsDownButton.whenPressed(new RampsUp(-.5, 5));
		
		Button rampsSolenoidExpandButton = new JoystickButton(operatorJoystick, RobotMap.RAMPS_SOLENOID_EXPAND_BUTTON);
		rampsSolenoidExpandButton.whenPressed(new RampsSolenoidExpand());
		
		Button solenoidRetractButton = new JoystickButton(operatorJoystick, RobotMap.RAMPS_SOLENOID_RETRACT_BUTTON);
		solenoidRetractButton.whenPressed(new RampsSolenoidRetract());
		
		Button transmissionSolenoidExpandButton = new JoystickButton(operatorJoystick, RobotMap.TRANSMISSION_SOLENOID_EXPAND_BUTTON);
		transmissionSolenoidExpandButton.whileHeld(new TransmissionSolenoidExpand());
		
		Button scaleButton = new JoystickButton(driverJoystick, RobotMap.SCALE_BUTTON);
		scaleButton.whileHeld(new TransmissionSolenoidExpand());
		
		//Button switchButton = new JoystickButton(operatorJoystick, RobotMap.LOADER_BUTTON);
		//switchButton.whileHeld(new PlaceCubeSwitch(.5));
		
		//Button rearmThrowerButton = new JoystickButton(driverJoystick, RobotMap.LOADER_BUTTON);
		//rearmThrowerButton.whenReleased(new LoadCube(-.5, 5));
		
		//Button grabCubeButton = new JoystickButton(driverJoystick, RobotMap.GRAB_CUBE_BUTTON);
		//grabCubeButton.whenPressed(new GrabCube(.5, 5));
		
		//Button releaseCubeButton = new JoystickButton(driverJoystick, RobotMap.RELEASE_CUBE_BUTTON);
		//releaseCubeButton.whenPressed(new GrabCube(-.5, 5));
		
		//Button lowerArmsButton = new JoystickButton(driverJoystick, RobotMap.ARMS_DOWN_BUTTON);
		//lowerArmsButton.whenPressed(new DeployArms(.5, 5));
		
		//Button raiseArmsButton = new JoystickButton(driverJoystick, RobotMap.ARMS_UP_BUTTON);
		//raiseArmsButton.whenPressed(new DeployArms(-.5, 5));
	
	}
	
}
