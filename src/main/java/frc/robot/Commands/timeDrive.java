/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class timeDrive extends Command {

  double time = 0.0;
  double target;
  double targetTime = 0.0;


  public timeDrive(double targetTime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    this.targetTime = targetTime;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    target = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

      Robot.drivetrain.autodrive(0.5, 0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() - target > targetTime;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.autodrive(0, 0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
