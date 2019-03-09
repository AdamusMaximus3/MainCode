/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import org.team217.pid.*;

/**
 * Add your docs here.
 */
public class ArmSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax armMotor = RobotMap.armController;
  CANSparkMax wristMotor = RobotMap.wristController;
  CANSparkMax elevatorMotor = RobotMap.elevatorController;

  //PID armPID = RobotMap.armPID;
  //PID armMaintainPID = RobotMap.armMaintainPID;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void armMover(double velocity){
    armMotor.set(velocity);
  }
  public void wristMover(double distanceOverTime){
    wristMotor.set(distanceOverTime);
  }
  public void elevatorMover(double displacementOverTime){
    elevatorMotor.set(displacementOverTime);
  }
}
