// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.GroundIntakeSubsystem;

public class RunGroundIntake extends CommandBase {
  /** Creates a new RunGroundIntake. */
  private GroundIntakeSubsystem groundIntakeSubsystem;
  public RunGroundIntake(GroundIntakeSubsystem groundIntakeSubsystem) {
    this.groundIntakeSubsystem = groundIntakeSubsystem;
    addRequirements(groundIntakeSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    groundIntakeSubsystem.coast();
    groundIntakeSubsystem.setAllPower(0.5);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    groundIntakeSubsystem.setAllPower(0);
    groundIntakeSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
