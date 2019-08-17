/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class driveForward extends PIDCommand {


 

  public driveForward(double distance) {
  
    super(0.9, 0, 0);
    requires(Robot.drivetrain);
    requires(Robot.sensors);

    Robot.sensors.ahrs.resetDisplacement();
  
    //USE THIS TO CALCULATE DISTANCE INSTEAD OF ENCODERTICKS SINCE WE DONT HAVE AN ENCODER
    //Robot.sensors.ahrs.getDisplacementY();

    this.setpoint(distance);

    getPIDController().enable();
    
  }

  public void setpoint(double value) {
    getPIDController().setSetpoint(value);
  }


  @Override
  protected double returnPIDInput() {
   
    return -9.0 * Robot.sensors.ahrs.getDisplacementY();
  }

  @Override
  protected void usePIDOutput(double output) {
    SmartDashboard.putNumber("dist", -Robot.sensors.ahrs.getDisplacementY() * 9.0);
    SmartDashboard.putBoolean("enabled", getPIDController().isEnabled());
    SmartDashboard.putNumber("output", output);
    SmartDashboard.putBoolean("isFinished", false);
    SmartDashboard.putNumber("setpoint", getPIDController().getSetpoint());

    Robot.drivetrain.autodrive(-output * 0.8, -output * 0.8);
  }

  @Override
  protected boolean isFinished() {
    SmartDashboard.putBoolean("isFinished", true);
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
