/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.PIDCommand;

import frc.robot.Robot;

public class driveForward extends PIDCommand {


 

  public driveForward(double distance) {
  
    super(1, 1, 1);
    requires(Robot.drivetrain);
    requires(Robot.sensors);
  
    //USE THESE TO CALCULATE DISTANCE INSTEAD OF ENCODERTICKS SINCE WE DONT HAVE AN ENCODER
    // ahrs.getDisplacementY();
    // ahrs.getDisplacementX();
    //Robot.sensors.ahrs.getDisplacementY();

    this.setpoint(distance / Robot.sensors.ahrs.getDisplacementY());

    getPIDController().enable();
    
  }

  public void setpoint(double value) {
    getPIDController().setSetpoint(0.5);
  }

  

  @Override
  protected double returnPIDInput() {
   
    return Robot.drivetrain.LEFT_1.getSensorCollection().getQuadraturePosition();
  }

  @Override
  protected void usePIDOutput(double output) {
   
    Robot.drivetrain.autodrive(output, output);
  }

  @Override
  protected boolean isFinished() {
    Robot.drivetrain.autodrive(0.0,0.0);
    return true;
  }

  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
