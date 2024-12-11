// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class TurnToTarget extends Command {
  /** Creates a new TurnToTarget. */
  private final DriveSubsystem drivetrain;
  private final LimelightSubsystem limelight;
  private double KpAim = -0.1f; 
  private double KpDistance = -0.1f;
  private double min_aim_command = 0.05f;
  private double kIntegral = 0;
  private double kDerivative = 0;
  private PIDController pidAIMController = new PIDController(KpAim, kIntegral, kDerivative); 
  private PIDController pidDistanceController = new PIDController(KpDistance, kIntegral, kDerivative);

  public TurnToTarget(DriveSubsystem drivetrain, LimelightSubsystem limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.limelight = limelight;

    addRequirements(drivetrain, limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /* 
    double heading_error = -limelight.getXOffset();
    double distance_error = -limelight.getYOffset();
    double steeringAdjust = 0.0;
  

    if (limelight.getXOffset() > 1.0) {
      steeringAdjust = KpAim * heading_error - min_aim_command;
    }
    else if (limelight.getXOffset() < -1.0){
      steeringAdjust = KpAim*heading_error + min_aim_command;
    }
    double distance_adjust = KpDistance * distance_error;

    drivetrain.driveArcade(distance_adjust, steeringAdjust);
    */
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
