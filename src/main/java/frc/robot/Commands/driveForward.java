/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class driveForward extends PIDCommand {


 

  public driveForward(double distance) {
  
    super(9, 0.1, 0); 
    requires(Robot.drivetrain);
    requires(Robot.sensors);

    Robot.sensors.ahrs.resetDisplacement();
  

    this.setpoint(distance);

    getPIDController().setOutputRange(-0.5, 0.5);
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

    Robot.drivetrain.drive(-output * 0.8, -output * 0.8);
  }

  @Override
  protected boolean isFinished() {
    SmartDashboard.putBoolean("isFinished", true);
    Robot.drivetrain.drive(0.0,0.0);
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