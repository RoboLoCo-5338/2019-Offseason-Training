/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class turn extends PIDCommand {
  /**
   * Add your docs here.
   */
  public turn(double angle) {
    // Intert a subsystem name and PID values here
    super(1, 2, 3);

    requires(Robot.drivetrain);
    requires(Robot.sensors);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.

    this.setpoint(angle);
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
    return Robot.sensors.ahrs.getYaw();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);

    Robot.drivetrain.autodrive(-output, output);
  }

@Override
protected boolean isFinished() {
  Robot.drivetrain.autodrive(0.0, 0.0);
  return true;
}

}
