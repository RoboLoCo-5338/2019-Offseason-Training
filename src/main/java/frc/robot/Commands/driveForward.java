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
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class driveForward extends PIDCommand {
  /**
   * Add your docs here.
   */

  double encoderticks;

  public driveForward(double distance) {
    // Intert a subsystem name and PID values here
    super(1, 1, 1);
    requires(Robot.drivetrain);
  

    encoderticks = (distance / 6 * Math.PI) * 4096;

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller

    this.setpoint(encoderticks);

    getPIDController().enable();
    
  }

  public void setpoint(double value) {
    getPIDController().setSetpoint(value);
  }

  

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return Robot.drivetrain.LEFT_1.getSensorCollection().getQuadraturePosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Robot.drivetrain.autodrive(output, output);
  }

  @Override
  protected boolean isFinished() {
    Robot.drivetrain.autodrive(0.0,0.0);
    return true;
  }
}
