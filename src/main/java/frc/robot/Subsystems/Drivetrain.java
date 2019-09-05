/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlFrame;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Commands.driveForward;
import frc.robot.Commands.startDrivetrain;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private NetworkTable table;
  public final WPI_TalonSRX LEFT_1 = new WPI_TalonSRX(3); // TODO: change Talon ID
	public final WPI_TalonSRX LEFT_2 = new WPI_TalonSRX(1); // TODO: change Talon ID
	public final WPI_TalonSRX RIGHT_1 = new WPI_TalonSRX(5); // TODO: change Talon ID
	public final WPI_TalonSRX RIGHT_2 = new WPI_TalonSRX(7); // TODO: change Talon ID

  private final SpeedControllerGroup LEFT_SIDE = new SpeedControllerGroup(this.LEFT_1, this.LEFT_2);
  private final SpeedControllerGroup RIGHT_SIDE = new SpeedControllerGroup(this.RIGHT_1, this.RIGHT_2);
  
  private final DifferentialDrive DRIVE = new DifferentialDrive(this.LEFT_SIDE, this.RIGHT_SIDE);
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new startDrivetrain());
  }

  public void drive(double l, double r){
    DRIVE.tankDrive(l, r);
  }
public void drive(OI oi) {
  double signL = 1;
  if (oi.getLeftJoystick('Y') < 0)
    signL = -1;

  double signR = 1;
  if (oi.getRightJoystick('Y') < 0)
    signR = -1;


  drive(oi.getLeftJoystick('Y') * oi.getLeftJoystick('Y') * signL * 0.7, oi.getRightJoystick('Y') * oi.getRightJoystick('Y') * signR * 0.7);
   
  }



 }
