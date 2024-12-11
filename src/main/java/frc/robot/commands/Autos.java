// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.KickerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;


public final class Autos {
  /** Example static factory for an autonomous command. */
  private DriveSubsystem m_drive;
  private ShooterSubsystem m_shoot;
  private KickerSubsystem m_roll;

  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand());
  }

  /*
  public static Command auto (DriveSubsystem drive, ShooterSubsystem shooter, FloorIntakeSubsystem floorIntake) {
    Timer time = new Timer();
    time.reset();
    time.start();
    shooter.shootNote();
    if (time.get() > 1 && time.get() < 2){
      floorIntake.ejectPiece();
    }
    else if (time.get() < 3){
      drive.driveArcade(.5, 0);
    }
    else if (time.get() > 4){
      floorIntake.lowerIntake();
    }
    else if (time.get() > 5){
      floorIntake.getPiece();
    }
    else if (time.get() > 6){
      floorIntake.raiseIntake();
    }
    else if (time.get() > 7){
      drive.driveArcade(-.5, 0);
    }
    else if (time.get() > 8){
      shooter.shootNote();
    }
    else if (time.get() > 9){
      floorIntake.ejectPiece();
    }
    else if (time.get() > 11){
      drive.driveArcade(.5, 0);
    }
  }
*/
  private Autos(DriveSubsystem subsystem, ShooterSubsystem subsystem2, KickerSubsystem subsystem3) {
    m_drive = subsystem;
    m_shoot = subsystem2;
    m_roll = subsystem3;
  }
}
