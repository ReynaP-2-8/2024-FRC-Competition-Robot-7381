// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new FloorIntakeSubsystem. */
  private DutyCycleEncoder m_Encoder;
  private Spark m_IntakeControl;
  public ArmSubsystem() {
    m_Encoder = new DutyCycleEncoder(Constants.FloorIntakeConstants.kDutyEncoder0);
    m_IntakeControl = new Spark(Constants.FloorIntakeConstants.kIntakeMotor1PWMId);

    m_Encoder.reset();
    m_Encoder.setPositionOffset(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double position = m_Encoder.getAbsolutePosition();
    SmartDashboard.putNumber("Encoder Position", position);
  }

  public void raiseIntake() {
    if (m_Encoder.getAbsolutePosition() < .4){
      m_IntakeControl.set(.4);
    }
  }

  public void lowerIntake() {
    if (m_Encoder.getAbsolutePosition() > 0.2){
      m_IntakeControl.set(-.4);
    }
  }
  public void idleIntake() {
    m_IntakeControl.set(0);
  }
 
}
