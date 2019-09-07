/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class startDrivetrain extends Command {  //open class
  public startDrivetrain() { //open startDrivetrain ()
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);\
    requires(Robot.drivetrain);
  } //end startDrivetrain ()

  // Called just before this Command runs the first time
  @Override
  protected void initialize() { //open initialize
  } //end initialize

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {  //open execute()
    Robot.drivetrain.drive(Robot.oi);
  } //end execute ()

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {  //open isFinished()
    return false;
  } //end isFinished()

  // Called once after isFinished returns true
  @Override
  protected void end() {  //open end()
  } //open end()

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {  //open interrupted ()
  } //end interrupted
} //end class
