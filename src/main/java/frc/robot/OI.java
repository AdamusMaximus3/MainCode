/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());
  
  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick driver1 = new Joystick(RobotMap.joyStick1);
  public Joystick driver2 = new Joystick(RobotMap.joystick2);

  Button level1Hatch = new JoystickButton(driver2, 7);
  Button level2Hatch = new JoystickButton(driver2, 8);
  Button level3Hatch = new JoystickButton(driver2, 9);
  Button level1Cargo = new JoystickButton(driver2, 10);
  Button level2Cargo = new JoystickButton(driver2, 11);
  Button level3Cargo = new JoystickButton(driver2, 12);
  Button ballOut = new JoystickButton(driver2, 1);
  Button ballIn = new JoystickButton(driver2, 2);
  Button hatchGrab = new JoystickButton(driver2, 3);
  Button hatchRelease = new JoystickButton(driver2, 4);
  Button camSwitch = new JoystickButton(driver2, 5);
  Button armDeploy = new JoystickButton(driver2, 6);

  Button camSwitchDriver = new JoystickButton(driver1, 5);
  Button turboDrive = new JoystickButton(driver1, 1);
  Button deployClimb = new JoystickButton(driver1, 2);

  
}
