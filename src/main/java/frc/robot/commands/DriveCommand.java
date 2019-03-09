/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;

public class DriveCommand extends Command {
  Spark ledSpark = RobotMap.ledSpark;
  DriverStation ds = DriverStation.getInstance();
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.kDriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.m_oi.driver1.getRawButton(1)){
      double speed = Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
      double turn = -0.55*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
      Robot.kDriveSubsystem.teleopDrive(speed, turn);
      ledSpark.set(-.05);
    }
    else {
      double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
      double turn = -0.55*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
      Robot.kDriveSubsystem.teleopDrive(speed, turn);
      if (ds.getAlliance() == Alliance.Invalid) {
        ledSpark.set(0.75);
      }
      if (ds.getAlliance() == Alliance.Red){
        ledSpark.set(0.87);
      }
      if (ds.getAlliance() == Alliance.Blue){
        ledSpark.set(0.61);
      }
      
      
    }
    
    
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}