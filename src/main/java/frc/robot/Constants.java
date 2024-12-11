// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAssistantControllerPort = 1;
  }

public static final class OIConstants {
  public static final double kDriveDeadband = 0.1;
  
}

  public static class DriveTrainConstants {
    public static final int kFrontLeftCANId = 10;
    public static final int kFrontRightCANId = 12;
    public static final int kRearLeftCANId = 11;
    public static final int kRearRightCANId = 13;

    public static final Boolean kFrontLeftInverted = true;
    public static final Boolean kFrontRightInverted = false;
    public static final Boolean kRearLeftInverted = true;
    public static final Boolean kRearRightInverted = false;

    public static final double kTurningScale = 0.5;
  }

  public static class ClimberConstants {
    //public static final int kLoweringLimitSwitch1 = 0; Removed due to Spark
    //public static final int kLoweringLimitSwitch2 = 1; Limit Switch Connections
    public static final int kClimberMotor1PWMId = 4; //adjust this value
    public static final int kClimberMotor2PWMId = 5;
  }

  public static class ShooterConstants {
    public static final int kShooterMotor1PWMId = 0;
    public static final int kShooterMotor2PWMId = 1;
    //public static final int kShooterTopCANId = 0;
    //public static final int kShooterBottomCANId = 1;
    }

  public static class GrabberConstants {
    public static final int kGrabberMotor1PWMId = 6;
  }

  public static class FloorIntakeConstants {
    public static final int kDutyEncoder0 = 0;
    public static final int kIntakeMotor1PWMId = 7;
    public static final int kIntakeMotor2PWMId = 2;
  }

  public static class VisionConstants {
    //TODO: Adjust values for Knightronz Robot
    //Find Distance using SOURCE_HEIGHT or SPEAKER_HEIGHT
    //divided by Math.tan(LIMELIGHT_ANGLE);
    public static final double kP = .3;
    public static final double kD_REFLECTIVE = .7;
    public static final double kD_APRIL = 1;

    public static final double ALIGNMENT_RANGE = 1; // horizontal degree
    public static final double DISTANCE_RANGE = 2; // inches
    public static final double LIMELIGHT_HALF_X_FOV = 29.8; 

    public static final double LIMELIGHT_HEIGHT = 20; //Adjusted for 2024
    public static final double LIMELIGHT_ANGLE = 0;   
    public static final double SOURCE_HEIGHT = 48.125; //Adjusted for 2024
    public static final double SPEAKER_HEIGHT = 51.875; //Adjusted for 2024
    public static final double AMP_HEIGHT = 48.125; // Adjusted for 2024

    public static final double LIMELIGHT_TO_SOURCE_HEIGHT = 28.125; //Adjusted for 2024
    public static final double LIMELIGHT_TO_SPEAKER_HEIGHT = 31.875; //Adjusted for 2024

    // drive to
    public static final double TARGET_DISTANCE = 40.0; // inches
    public static final double kP_DRIVE = 0.005;
    public static final double kD_DRIVE = 0.01;
  }
}
