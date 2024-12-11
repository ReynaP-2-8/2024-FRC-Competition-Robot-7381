// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.KickerSubsystem;

public class KickerCommand extends Command {
  private static KickerSubsystem m_KickerSubsystem;

  /** Creates a new FloorIntakeCommand. */
  public KickerCommand(KickerSubsystem floorIntake) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_KickerSubsystem = floorIntake;

    addRequirements(m_KickerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        m_KickerSubsystem.ejectPiece();
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