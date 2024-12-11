// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.KickerSubsystem;

public class FloorIntakeRollerStopCommand extends Command {
  /** Creates a new FloorIntakeStopCommand. */
  private KickerSubsystem m_floorIntake;
  public FloorIntakeRollerStopCommand(KickerSubsystem subsystem) {
    m_floorIntake = subsystem;
    addRequirements(m_floorIntake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_floorIntake.idleRollers();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_floorIntake.idleRollers();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
