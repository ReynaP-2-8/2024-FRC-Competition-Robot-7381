// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GrabberSubsystem extends SubsystemBase {
  private Spark m_GrabberMotor;
  /** Creates a new GrabberSubsystem. */
  public GrabberSubsystem() {
    m_GrabberMotor = new Spark(Constants.GrabberConstants.kGrabberMotor1PWMId);
  }

  public void grabPiece(){
    m_GrabberMotor.set(.3);
  }

  public void putPiece(){
    m_GrabberMotor.set(-.3);
  }

  public void idleMotor() {
    m_GrabberMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
