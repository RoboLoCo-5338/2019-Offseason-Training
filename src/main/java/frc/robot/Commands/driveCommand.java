/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class driveCommand extends Command {
  public driveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);


    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.drive(Robot.oi);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  
  
  package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

public class driveForward extends PIDCommand {


  double encoderticks;

  public driveForward(double distance) {
  
    super(1, 1, 1);
    requires(Robot.drivetrain);
  

    encoderticks = (distance / 6 * Math.PI) * 4096;

   

    this.setpoint(encoderticks);

    getPIDController().enable();
    
  }

  public void setpoint(double value) {
    getPIDController().setSetpoint(value);
  }

  

  @Override
  protected double returnPIDInput() {
   
    return Robot.drivetrain.LEFT_1.getSensorCollection().getQuadraturePosition();
  }

  @Override
  protected void usePIDOutput(double output) {
   
    Robot.drivetrain.drive(output, output);
  }

  @Override
  protected boolean isFinished() {
    Robot.drivetrain.drive(0.0,0.0);
    return true;
  }
}
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
