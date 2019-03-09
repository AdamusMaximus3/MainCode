/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.team217.pid.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.CANEncoder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int driveRF = 3;
  public static int driveRR = 4;
  public static int driveLF = 10;
  public static int driveLR = 2;

  public static int armControl = 5;
  public static int wristControl = 6;
  public static int elevatorControl = 7;
  public static int intake2 = 8;

  public static int solenoid1 = 0;
  public static int solenoid2 = 1;

  public static int cam1 = 0;
  public static int cam2 = 1;

  public static int ledDriver = 2;

  public static int pressureSense = 0;

  public static int pdpCan = 9;
  public static int pcmCAN = 8;

  public static int joyStick1 = 0;
  public static int joystick2 = 1;

	//public static PID wristPID = new PID(0.0, 0.0, 0.0, 100);
	//public static PID armPID = new PID(0.0, 0.0, 0.0, 100);
	//public static PID armMaintainPID = new PID(0.0, 0.0, 0.0, 100);

  public static CANSparkMax rightMaster = new CANSparkMax(RobotMap.driveRF, MotorType.kBrushless);
  public static CANSparkMax rightBackSlave = new CANSparkMax(RobotMap.driveRR, MotorType.kBrushless);
  public static CANSparkMax leftMaster = new CANSparkMax(RobotMap.driveLF, MotorType.kBrushless);
  public static CANSparkMax leftBackSlave = new CANSparkMax(RobotMap.driveLR, MotorType.kBrushless);

  public static CANSparkMax armController = new CANSparkMax(RobotMap.armControl, MotorType.kBrushless);
  public static CANSparkMax wristController = new CANSparkMax(RobotMap.wristControl, MotorType.kBrushless);
  public static CANSparkMax elevatorController = new CANSparkMax(RobotMap.elevatorControl, MotorType.kBrushless);
  public static Spark ledSpark = new Spark(2);
  public static Compressor c = new Compressor(0);
  public static CANEncoder arm = new CANEncoder(armController);
  public static CANEncoder wrist = new CANEncoder(wristController);  
  public static boolean enabled = c.enabled();
  public static boolean pressureSwitch = c.getPressureSwitchValue();
  public static double current = c.getCompressorCurrent();
  public static DoubleSolenoid pusher = new DoubleSolenoid(0, 1);
 // public static CANSparkMax wristController = new CANSparkMax(RobotMap.wristControl, MotorType.kBrushless);

}
