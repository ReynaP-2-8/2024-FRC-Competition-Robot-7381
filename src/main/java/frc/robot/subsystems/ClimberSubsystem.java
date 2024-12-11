// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
  private Spark m_ClimberMotor1;
  private Spark m_ClimberMotor2;
  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {
    m_ClimberMotor1 = new Spark(Constants.ClimberConstants.kClimberMotor1PWMId);
    m_ClimberMotor2 = new Spark(Constants.ClimberConstants.kClimberMotor2PWMId);
  }

  public Command raiseClimber(){
    return runEnd(
      () -> {
        climberArmUp();
      },
      () -> {
        idleClimber();
      }
    );
  }

  public Command lowerClimber(){
    return runEnd(
      () -> {
        climberArmDown();
      }, 
      () -> {
        idleClimber();
      });
  }

  public void climberArmUp(){
    m_ClimberMotor1.set(-1);
    m_ClimberMotor2.set(1);
  }

  public void climberArmDown(){
    m_ClimberMotor1.set(1);
    m_ClimberMotor2.set(-1);
  }

  public void idleClimber(){
    m_ClimberMotor1.set(0);
    m_ClimberMotor2.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
