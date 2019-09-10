/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//once upon a time there was a bunny named goerge
//goerge was sad because his name was weird
//he cried
//he cried and cried
//eventually a bird found him
//he were like yo dude why are you crying
//and goerge said im crying because my name is goerge
//then the bird said thats a stupid name go die
//goerge got even more sad

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class shootCommand extends Command {
  public shootCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
   // requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  //  Robot.shooter.shootBalls(Robot.oi);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
