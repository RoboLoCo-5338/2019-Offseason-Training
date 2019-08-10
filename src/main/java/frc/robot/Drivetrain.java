/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public final WPI_TalonSRX LEFT_1 = new WPI_TalonSRX(1);
  public final WPI_TalonSRX LEFT_2 = new WPI_TalonSRX(4);
  public final WPI_TalonSRX RIGHT_1 = new WPI_TalonSRX(5);
  public final WPI_TalonSRX RIGHT_2 = new WPI_TalonSRX(7);


  private final SpeedControllerGroup leftController = new SpeedControllerGroup(this.LEFT_1, this.LEFT_2);
  private final SpeedControllerGroup rightController = new SpeedControllerGroup(this.RIGHT_1, this.RIGHT_2);

  private final DifferentialDrive drive = new DifferentialDrive(leftController, rightController);

  

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
