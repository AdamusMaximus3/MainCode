/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArmCommand extends Command {
  public ArmCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.kArmSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.m_oi.driver2.getRawButton(7)== true){
        while (RobotMap.armController.getEncoder().getPosition() < 33){
            RobotMap.armController.set(1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.69);
        } 
    }
        else {
            RobotMap.armController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(9)== true){
        while (RobotMap.armController.getEncoder().getPosition() < 67){
            RobotMap.armController.set(1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.65);
        } 
    }
        else {
            RobotMap.armController.set(0); //hey
        
    }
    if (Robot.m_oi.driver2.getRawButton(11)== true){
        while (RobotMap.armController.getEncoder().getPosition() < 100){
            RobotMap.armController.set(1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.57);
        } 
    }
        else {
            RobotMap.armController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(2)== true){
        while (RobotMap.armController.getEncoder().getPosition() > 0){
            RobotMap.armController.set(-1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.83);
            
        } 
    }
        else {
            RobotMap.armController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(8)== true){
        while (RobotMap.wristController.getEncoder().getPosition() > -233){
            RobotMap.wristController.set(-1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.03);
        } 
    }
        else {
            RobotMap.wristController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(10)== true){
        while (RobotMap.wristController.getEncoder().getPosition() > -467){
            RobotMap.wristController.set(-1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.05);
        } 
    }
        else {
            RobotMap.wristController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(12)== true){
        while (RobotMap.wristController.getEncoder().getPosition() > -700){
            RobotMap.wristController.set(-1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.07);
        } 
    }
        else {
            RobotMap.wristController.set(0);
        
    }
    if (Robot.m_oi.driver2.getRawButton(1)== true){
        while (RobotMap.wristController.getEncoder().getPosition() < 0){
            RobotMap.wristController.set(1);
            double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
            double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
            Robot.kDriveSubsystem.teleopDrive(speed, turn);
            RobotMap.ledSpark.set(0.09);
        } 
    }
        else {
            RobotMap.wristController.set(0);
        
        }
        if (Robot.m_oi.driver1.getRawButton(7)== true){
            while (RobotMap.elevatorController.getEncoder().getPosition() > -100){
                RobotMap.elevatorController.set(-1);
                double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
                double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
                Robot.kDriveSubsystem.teleopDrive(speed, turn);
                RobotMap.ledSpark.set(0.23);
            } 
        }
            else {
                RobotMap.elevatorController.set(0);
            
        }
        if (Robot.m_oi.driver1.getRawButton(9)== true){
            while (RobotMap.elevatorController.getEncoder().getPosition() > -200){
                RobotMap.elevatorController.set(-1);
                double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
                double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
                Robot.kDriveSubsystem.teleopDrive(speed, turn);
                RobotMap.ledSpark.set(0.25);
            } 
        }
            else {
                RobotMap.elevatorController.set(0);
            
        }
        if (Robot.m_oi.driver1.getRawButton(11)== true){
            while (RobotMap.elevatorController.getEncoder().getPosition() > -300){
                RobotMap.elevatorController.set(-1);
                double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
                double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
                Robot.kDriveSubsystem.teleopDrive(speed, turn);
                RobotMap.ledSpark.set(0.27);
            } 
        }
            else {
                RobotMap.elevatorController.set(0);
            
        }
        if (Robot.m_oi.driver1.getRawButton(2)== true){
            while (RobotMap.elevatorController.getEncoder().getPosition() < 0){
                RobotMap.elevatorController.set(1);
                double speed = 0.75*Robot.deadband(-Robot.m_oi.driver1.getRawAxis(1), 0.075);
                double turn = -1*0.5*Robot.deadband(Robot.m_oi.driver1.getRawAxis(2), 0.075);
                Robot.kDriveSubsystem.teleopDrive(speed, turn);
                RobotMap.ledSpark.set(0.29);
            } 
        }
            else {
                RobotMap.elevatorController.set(0);
            
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