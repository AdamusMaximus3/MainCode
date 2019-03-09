/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TeleopCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ArmSystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static DriveSubsystem kDriveSubsystem = new DriveSubsystem();
  public static ArmSystem kArmSystem = new ArmSystem();
  public static OI m_oi;
  public static SpeedControllerGroup leftDrive = new SpeedControllerGroup(RobotMap.leftMaster, RobotMap.leftBackSlave);
  public static SpeedControllerGroup rightDrive = new SpeedControllerGroup(RobotMap.rightMaster, RobotMap.rightBackSlave);
  public static DifferentialDrive kDrive = new DifferentialDrive(rightDrive, leftDrive);
  Command m_autonomousCommand;
  Command m_teleOpCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(640, 480);
      
      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
      
      Mat source = new Mat();
      Mat output = new Mat();
      
      while(!Thread.interrupted()) {
          cvSink.grabFrame(source);
          Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
          outputStream.putFrame(output);
      }
  }).start();
    RobotMap.c.setClosedLoopControl(true);
    m_oi = new OI();
    Spark ledSpark = RobotMap.ledSpark;
    ledSpark.set(-0.89);
    RobotMap.wrist.setPosition(0);
    RobotMap.arm.setPosition(0);
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    AnalogInput pressureSensor = new AnalogInput(0);
    int raw = pressureSensor.getValue();
    double volts = pressureSensor.getVoltage();
    int averageRaw = pressureSensor.getAverageValue();
    double averageVolts = pressureSensor.getAverageVoltage();
    double psi = 250*(raw/volts) - 25;
    SmartDashboard.putNumber("psi", psi); 
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
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
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
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    m_teleOpCommand = new TeleopCommandGroup();
    m_teleOpCommand.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override      
  public void teleopPeriodic() {
    

    Scheduler.getInstance().run();
    if (Robot.m_oi.driver2.getRawButton(5) == true && Robot.m_oi.driver2.getRawButton(3) == false){
      RobotMap.pusher.set(DoubleSolenoid.Value.kForward);
    }
    if (Robot.m_oi.driver2.getRawButton(3) == true && Robot.m_oi.driver2.getRawButton(5) == false){
      RobotMap.pusher.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public static double deadband(double value, double deadband) {
		if (Math.abs(value) <= Math.abs(deadband)) {
			value = 0.0;
		}

		return value;
	}

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
