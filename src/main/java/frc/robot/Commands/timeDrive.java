
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class timeDrive extends Command {

  double time = 0.0;
  double target;
  double targetTime = 0.0;
  double initialYaw; 
  double kp = 0.01; 
  double error;

  public timeDrive(double targetTime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.sensors);
    requires(Robot.drivetrain);

    
    this.targetTime = targetTime;

    System.out.println(initialYaw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putString("Current Command", "timeDrive");
    initialYaw = Robot.sensors.ahrs.getYaw(); 
    target = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    error = initialYaw - Robot.sensors.ahrs.getYaw();

    Robot.drivetrain.autodrive(0.5 + kp * error, 0.5 - kp * error);
    SmartDashboard.putNumber("time", System.currentTimeMillis());
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
