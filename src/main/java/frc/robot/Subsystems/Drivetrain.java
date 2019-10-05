/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Commands.driveCommand;
import frc.robot.Commands.turn;



public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final WPI_TalonSRX LEFT_1 = new WPI_TalonSRX(1);
  public final WPI_TalonSRX LEFT_2 = new WPI_TalonSRX(3);
  public final WPI_TalonSRX RIGHT_1 = new WPI_TalonSRX(5);
  public final WPI_TalonSRX RIGHT_2 = new WPI_TalonSRX(7);


  private final SpeedControllerGroup rightController = new SpeedControllerGroup(this.LEFT_1, this.LEFT_2);
  private final SpeedControllerGroup leftController = new SpeedControllerGroup(this.RIGHT_1, this.RIGHT_2);

  private final DifferentialDrive DRIVE = new DifferentialDrive(leftController, rightController);

  boolean isToggled = false;
  float speed = 0.5f;
  
public void drive(OI oi) {
  
  double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);

  if(oi.get(OI.Button.limelight)) {

    double speedLimit = 0.03;
    
    autodrive(-tx * speedLimit + oi.getLeftJoystick('Y') * 0.5, tx * speedLimit + oi.getLeftJoystick('Y') * 0.5);
    return;
  }

  // if(oi.get(OI.Button.perpLimelight)) {
  //   double forwardkp = 0.0; 
  //   double currentWidth = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0.0);
  //   double width = 39.0;
  //   double constY = -4.85;
  //   double frac = width/currentWidth;
  //   double angle = Math.asin(frac);
  //   double angleDeg = Math.toDegrees(angle);
  //   double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
    
  //   SmartDashboard.putNumber("current width", currentWidth);
  //   SmartDashboard.putNumber("fraction", frac);
  //   SmartDashboard.putNumber("angle", angle);
  //   SmartDashboard.putNumber("degrees angle", angleDeg);
  //   SmartDashboard.putNumber("ty", ty);

 

  //   return; 
  // }



  if(oi.get(OI.Button.changeSpeed)) {
    isToggled = !isToggled;
  }


  if (isToggled){
    speed = 0.6f;
  }

  else{
    speed = 0.5f;
  }

  
  DRIVE.tankDrive(oi.getLeftJoystick('Y') * speed, oi.getRightJoystick('Y') * speed);

}

public void autodrive (double left, double right) {
  DRIVE.tankDrive(left, right);
}

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new driveCommand());
  }
}

