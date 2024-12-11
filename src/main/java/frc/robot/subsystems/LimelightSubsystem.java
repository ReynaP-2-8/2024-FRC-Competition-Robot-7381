// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.VisionConstants;

public class LimelightSubsystem extends SubsystemBase {
  /** Creates a new LimelightSubsystem. 
  private static double TAN_CALC;
  private final NetworkTable limelightTable;
  public LimelightSubsystem() {
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    TAN_CALC = Math.tan(Constants.VisionConstants.LIMELIGHT_ANGLE);                                                                              

  }

  public boolean hasValidTarget() {
    return getValue("tv") == 1;
  }

  public double getXOffset() {
    return getValue("tx");
  }

  public double getYOffset() {
    return getValue("ty");
  }

  public double getArea() {
    return getValue("ta");
  }

  public double getSkew() {
    return getValue("ts");
  }

  private double getValue(String key) {
    NetworkTableEntry entry = limelightTable.getEntry(key);
    return entry.getDouble(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run 
  }*/
  NetworkTable table;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry tv;
  NetworkTableEntry ta;

  double xOffset;
  double yOffset;
  boolean hasTarget;
  double area;
  double speed;
  double lastHeadingError;

  double driveSpeed;
  double lastDistance;
  double distance;
  double pipeline;

  boolean reflective;

  DriveSubsystem m_drive;

  public LimelightSubsystem(DriveSubsystem drive){
    this.table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    tv = table.getEntry("tv");
    ta = table.getEntry("ta");
    this.m_drive = drive;
    speed = 0.0;
    driveSpeed = 0.0;
    lastHeadingError = 0.0;
    distance = 0.0;
    table.getEntry("pipeline").setValue(0);
  }
  public void ameliorateX(){
    double slope = 0.0;
    double heading_error = xOffset / VisionConstants.LIMELIGHT_HALF_X_FOV;
    if (speed != 0.0){
      slope = heading_error - lastHeadingError;
      
    }
    if (xOffset > VisionConstants.ALIGNMENT_RANGE){
      speed = -((VisionConstants.kP*heading_error)+(slope*VisionConstants.kD_APRIL)/100);
    }
    else if (xOffset < -VisionConstants.ALIGNMENT_RANGE){
      speed = -((VisionConstants.kP * heading_error) + (slope * VisionConstants.kD_APRIL));
    }
    else {
      speed = 0.0;
    }
    m_drive.m_frontLeft.set(speed);
    m_drive.m_rearLeft.set(speed);
    m_drive.m_frontRight.set(speed);
    m_drive.m_rearRight.set(speed);
    lastHeadingError = heading_error;
  }
  public void stopMotor(){
    m_drive.m_frontLeft.set(0.0);
    m_drive.m_rearLeft.set(0.0);
    m_drive.m_frontRight.set(0.0);
    m_drive.m_rearRight.set(0.0);
  }

  public double getXoffset(){
    //x location of the target
    tx = table.getEntry("tx");
    return tx.getDouble(0.0);
  }
  /*
  public double GetApriltagId(){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("tid").getDoubleArray(<default variable>); //Find Solution
  }
  */
}
