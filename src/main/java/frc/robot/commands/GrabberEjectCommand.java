// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.GrabberSubsystem;

public class GrabberEjectCommand extends Command {
  /** Creates a new GrabberEjectCommand. */
  private GrabberSubsystem m_GrabberSubsystem;
  public GrabberEjectCommand(GrabberSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_GrabberSubsystem = subsystem;
    addRequirements(m_GrabberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_GrabberSubsystem.putPiece();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_GrabberSubsystem.idleMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
