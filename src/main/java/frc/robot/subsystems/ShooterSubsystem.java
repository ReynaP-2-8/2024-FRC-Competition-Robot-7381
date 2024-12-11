// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private PWMSparkMax m_ShooterMotor1;
  private PWMSparkMax m_ShooterMotor2;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    m_ShooterMotor1 = new PWMSparkMax(Constants.ShooterConstants.kShooterMotor1PWMId);
    m_ShooterMotor2 = new PWMSparkMax(Constants.ShooterConstants.kShooterMotor2PWMId);
  }

public void intakeNote() {
      /* one-time action goes here */
      m_ShooterMotor1.set(-.33);
      m_ShooterMotor2.set(-.33);

}
public void shootNote(){
      /* one-time action goes here */
      m_ShooterMotor1.set(1.0);
      m_ShooterMotor2.set(1.0);
      }

public void idleMotors(){
      m_ShooterMotor1.set(0.0);
      m_ShooterMotor2.set(0.0);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
