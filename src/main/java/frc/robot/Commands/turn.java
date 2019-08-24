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

/**
 * Add your docs here.
 */
public class turn extends PIDCommand {
  /**
   * Add your docs here.
   */
  public double angle;

   public turn(double angle) {
    // Intert a subsystem name and PID values here

    super(0.41275, 0, 0);

    requires(Robot.drivetrain);
    requires(Robot.sensors);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.

    getPIDController().setOutputRange(-0.5, 0.5);
    this.angle = angle;
    

    //getPIDController().enable();
  }

  @Override
  protected void initialize() {
    super.initialize();
    Robot.sensors.ahrs.reset();
    this.setpoint(angle);
    SmartDashboard.putString("Current Command", "turn");
    getPIDController().enable();
  }

  public void setpoint(double value) {
    //sets point to turn to
    getPIDController().setSetpoint(value);
    SmartDashboard.putData(this);
  }


  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return -Robot.sensors.ahrs.getYaw();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    SmartDashboard.putNumber("angle", Robot.sensors.ahrs.getYaw());
    SmartDashboard.putNumber("setpoint", getPIDController().getSetpoint());
    Robot.drivetrain.autodrive(-output, output);
  }

@Override
protected boolean isFinished() {
  return Math.abs(getPIDController().getError()) < 0.1;

}

@Override
protected void end() {
  getPIDController().disable();
  // Robot.sensors.ahrs.reset();
}

}
