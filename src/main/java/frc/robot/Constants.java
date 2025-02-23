// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class SwerveConstants {
        //Not sure how to calculate this theoretically but this needs to be determined experimentally first
        public static double maxSpeed = 2.0;
        /*
        * IMPORTANT: THIS WAS FOUND THROUGH CAD FILES BUT THERE ARE MANY SWERVE X CONFIGURATIONS
        * SO YOU NEED TO DOUBLE CHECK THIS IS CORRECT IN PRACTICE
        */
        /* ANGLE MOTOR
        * NEO Shaft to 12T Pulley to 24T Pulley to 14T Gear to 72T Main Rotation Gear
        */
        public static double gearRatioAngleMotor = (double) 12.0/24.0*14.0/72.0;
        /* DRIVE MOTOR
        * NEO shaft to 12T Pulley to 24T Pulley to 24T Gear to 22T Gear to 15T bevel to 45T Bevel
        *
        * The CANCODER measures rotations of a the driven 1:1 PULLEY in which the driver pulley is on the same
        * shaft as the 24T Pulley
        */
        public static double gearRatioSpeedMotor = (double) 12.0/24.0* 24.0/22.0 * 15.0/45.0;
        /*
        * So Number of Rotations of this CANCOder sensor measured means this amount of rotations in actual SPEED wheel
        */
        public static double gearRatioCANCoder = (double) 24.0/22.0 * 15.0/45.0;
        public static double wheelDiameter = Units.inchesToMeters(4.0);
        public static double wheelCircumfrence = wheelDiameter * 2 * Math.PI;
        public static final double anglekP = 0.6;
        public static final int pigeonID = 0;
        //TODO: set the correct turnEncoder IDs
        //INFO: according to WPILib docs "The locations for the modules must be relative to the center of the robot. Positive x
        //values represent moving toward the front of the robot whereas positive y values represent moving toward the left of the robot." 
        public static final SwerveModuleConstants frontLeft = new SwerveModuleConstants(
          2, 1, 0, new Translation2d(RobotConstants.HALF_LENGTH, RobotConstants.HALF_LENGTH) );
        public static final SwerveModuleConstants frontRight = new SwerveModuleConstants(
          4, 3, 0, new Translation2d(RobotConstants.HALF_LENGTH, -RobotConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backLeft = new SwerveModuleConstants(
          6, 5, 0, new Translation2d(-RobotConstants.HALF_LENGTH, RobotConstants.HALF_LENGTH));
        public static final SwerveModuleConstants backRight = new SwerveModuleConstants(
          8, 7, 0, new Translation2d(-RobotConstants.HALF_LENGTH, -RobotConstants.HALF_LENGTH));
        public static final SwerveDriveKinematics swerveDriveKinematics = new SwerveDriveKinematics(frontLeft.location, frontRight.location, backLeft.location, backRight.location);
      }
      public static class SwerveModuleConstants {
        public int driveMotorID;
        public int turnMotorID;
        public int turnEncoderID;
        public Translation2d location;
        public SwerveModuleConstants(int driveMotorID, int turnMotorID, int turnEncoderID, Translation2d location) {
          this.driveMotorID = driveMotorID;
          this.turnMotorID = turnMotorID;
          this.turnEncoderID = turnEncoderID;
          this.location = location;
        }
    }
    public static class GroundIntakeConstants {
        public static final double stallVelocityThreshold = 500;
        public static final double groundIntakeDelaySeconds = 0.5;
        //TODO: fix can IDs
        public static final int leftIntakeID = 0;
        public static final int rightIntakeID = 0;
    }
    
    public static class RobotConstants {

        public static final double TalonFXTicksPerRotation = 2048;

        public static final double kTrackWidth = 0.6858; // meters

        public static final double kWheelRadius = 3 * 0.0254; // We use Hi-Grip 6 inch wheels so convert to meters
        public static final double kWheelCircumference = 2 * Math.PI * Constants.RobotConstants.kWheelRadius;

        public static final double timeStep = 0.2; //how often periodic() function runs
        public static final double LENGTH = Units.inchesToMeters(26.5);
        public static final double HALF_LENGTH = LENGTH/2.0;

    }
    public static class ArmConstants {
        public static final double kP = 0.0001;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kTolerance = 100;
    }
    public static class PowerConstants {
        public static final double autoDockPower = 0.2;
        public static final double DriveBaseStraight = .55;
        public static final double DriveBaseTurn = .35;
        public static final double groundIntakePower = 0.5; //arbitrary for now
        public static final double ArmPower = 0.2;//arbitrary for now
        public static double WristPower = 0.5; //random # for now
    }
    public static class WristConstants {
        //TODO: placeholders replace with actual values
        public static final double kP = 0.0001;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kTolerance = 100;
        public static final double downSetpoint = 0;
        public static final double upSetpoint = 0;
        public static final int wristCanID = 0;
    }

    public static class DriveConstants{
        public static final double driveKS = 0.0;
        public static final double driveKV = 0.0;
        public static final double driveKA = 0.0;
    }
    public static class AngleOffset {
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(37.35);
    }
    public static final Port SerialPortAHRS = null;
    public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}