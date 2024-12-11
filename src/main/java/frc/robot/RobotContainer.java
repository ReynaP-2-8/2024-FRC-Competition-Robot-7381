// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ClimberDownCommand;
import frc.robot.commands.ClimberUpCommand;
import frc.robot.commands.FloorIntakeDownCommand;
import frc.robot.commands.FloorIntakeIntakeCommand;
import frc.robot.commands.KickerCommand;
import frc.robot.commands.FloorIntakeRollerStopCommand;
import frc.robot.commands.FloorIntakeUpCommand;
import frc.robot.commands.GrabberEjectCommand;
import frc.robot.commands.GrabberIntakeCommand;
import frc.robot.commands.ShooterGetCommand;
import frc.robot.commands.ShooterShootCommand;
//import frc.robot.commands.TurnToTarget;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystem;
import frc.robot.subsystems.KickerSubsystem;
//import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import javax.management.timer.Timer;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final DriveSubsystem m_drivetrain = new DriveSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final GrabberSubsystem m_GrabberSubsystem = new GrabberSubsystem();
  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();
  private final ArmSubsystem m_ArmSubsystem = new ArmSubsystem();
  private final KickerSubsystem m_RollerSubsystem = new KickerSubsystem();
  //private final LimelightSubsystem m_LimelightSubsystem = new LimelightSubsystem();

  private final CommandJoystick m_driverController = 
    new CommandJoystick(OperatorConstants.kDriverControllerPort);
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_assistantController =
      new CommandXboxController(OperatorConstants.kAssistantControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    CameraServer.startAutomaticCapture();
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    //Face Button Assignments
    /*m_assistantController.a().whileTrue(
      new FloorIntakeDownCommand(m_ArmSubsystem)
      .handleInterrupt(() -> m_ArmSubsystem.idleIntake()));*/

    m_assistantController.b().whileTrue(
      new FloorIntakeUpCommand(m_ArmSubsystem)
      .handleInterrupt(() -> m_ArmSubsystem.idleIntake()));

    m_assistantController.x().whileTrue(
      new GrabberIntakeCommand(m_GrabberSubsystem)
      .handleInterrupt(() -> m_GrabberSubsystem.idleMotor()));

    m_assistantController.y().whileTrue(
      new GrabberEjectCommand(m_GrabberSubsystem)
      .handleInterrupt(() -> m_GrabberSubsystem.idleMotor()));
    
    //Bumper and Trigger Assignments
    m_assistantController.rightBumper().whileTrue(
      new KickerCommand(m_RollerSubsystem)
      .handleInterrupt(() -> m_RollerSubsystem.idleRollers()));

    m_assistantController.a().whileTrue(
      new FloorIntakeIntakeCommand(m_RollerSubsystem)
      .handleInterrupt(() -> m_RollerSubsystem.idleRollers()));

    m_assistantController.rightTrigger(.1).whileTrue(
      new ShooterGetCommand(m_ShooterSubsystem)
      .handleInterrupt(() -> m_ShooterSubsystem.idleMotors()));

    m_assistantController.leftTrigger(.1).whileTrue(
      new ShooterShootCommand(m_ShooterSubsystem)
      .handleInterrupt(() -> m_ShooterSubsystem.idleMotors()));

    //Drive Command Code
    m_drivetrain.setDefaultCommand(new RunCommand(
      ()->
        m_drivetrain.driveArcade(
          MathUtil.applyDeadband(-m_driverController.getY(), Constants.OIConstants.kDriveDeadband),
          MathUtil.applyDeadband(-m_driverController.getX() * Constants.DriveTrainConstants.kTurningScale, Constants.OIConstants.kDriveDeadband))
       ,m_drivetrain)
    );

    //Assignment to Buttons on driver controller
    m_driverController.button(3).whileTrue(
      new ClimberUpCommand(m_ClimberSubsystem)
      .handleInterrupt(() -> m_ClimberSubsystem.idleClimber()));

    m_driverController.button(4).whileTrue(
      new ClimberDownCommand(m_ClimberSubsystem)
      .handleInterrupt(() -> m_ClimberSubsystem.idleClimber()));
  } 

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return Autos.exampleAuto(m_exampleSubsystem);
    // return new InstantCommand()
    // return new PathPlannerAuto("Straight Auto");
    // ParallelRaceGroup command = new ParallelRaceGroup(null)
    // return new ParallelRaceGroup(new InstantCommand(() -> m_drivetrain.driveArcade(0.5, 0)), new WaitCommand(2));
    //return new ParallelRaceGroup(Commands.runEnd(() -> m_drivetrain.driveArcade(0.5, 0), () -> m_drivetrain.stopDrive()), new WaitCommand(2.0));

    return new ParallelDeadlineGroup(new WaitCommand(2), m_drivetrain.autoDriveCommand());
  }
}
