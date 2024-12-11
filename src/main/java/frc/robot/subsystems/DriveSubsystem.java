// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  public CANSparkMax m_frontLeft;
  public CANSparkMax m_frontRight;
  public CANSparkMax m_rearLeft;
  public CANSparkMax m_rearRight;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    m_frontLeft = new CANSparkMax(Constants.DriveTrainConstants.kFrontLeftCANId, CANSparkLowLevel.MotorType.kBrushless);
    m_frontLeft.setInverted(Constants.DriveTrainConstants.kFrontLeftInverted);

    m_frontRight = new CANSparkMax(Constants.DriveTrainConstants.kFrontRightCANId, CANSparkLowLevel.MotorType.kBrushless);
    m_frontRight.setInverted(Constants.DriveTrainConstants.kFrontRightInverted);

    m_rearLeft = new CANSparkMax(Constants.DriveTrainConstants.kRearLeftCANId, CANSparkLowLevel.MotorType.kBrushless);
    m_rearLeft.setInverted(Constants.DriveTrainConstants.kRearLeftInverted);

    m_rearRight = new CANSparkMax(Constants.DriveTrainConstants.kRearRightCANId, CANSparkLowLevel.MotorType.kBrushless);
    m_rearRight.setInverted(Constants.DriveTrainConstants.kRearRightInverted);
  }

public void driveArcade(double _straight, double _turn){
  double left = MathUtil.clamp(_straight + _turn, -1.0, 1.0);
  double right = MathUtil.clamp(_straight - _turn, -1.0, 1.0);

  m_frontLeft.set(left);
  m_frontRight.set(right);
  m_rearLeft.set(left);
  m_rearRight.set(right);
}

public void stopDrive() {
  m_frontLeft.set(0);
  m_frontRight.set(0);
  m_rearLeft.set(0);
  m_rearRight.set(0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command autoDriveCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
            driveArcade(-.25, 0);
          });
        };
}


