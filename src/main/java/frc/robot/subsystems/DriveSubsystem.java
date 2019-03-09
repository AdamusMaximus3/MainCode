/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax rightMaster1 = RobotMap.rightMaster;
  CANSparkMax leftMaster1 = RobotMap.leftMaster;
  CANSparkMax rightBackSlave1 = RobotMap.rightBackSlave;
  CANSparkMax leftBackSlave1 = RobotMap.leftBackSlave;
  CANEncoder encoderR = rightBackSlave1.getEncoder();
  CANEncoder encoderL = leftBackSlave1.getEncoder();

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

  public void teleopDrive(double speed, double turn){
    rightBackSlave1.follow(rightMaster1);
    double leftSpeed = speed + turn;
    double rightSpeed = speed - turn;
    
    Robot.kDrive.tankDrive(-1*leftSpeed, -1*rightSpeed);

    System.out.println("EncoderR: " + encoderR.getPosition());
    System.out.println("EncoderL: " + encoderL.getPosition());
  }

}
