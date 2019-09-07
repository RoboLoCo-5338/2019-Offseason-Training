/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

/**
 * Add your docs here.
 */
public class Sensors extends Subsystem {  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final AHRS ahrs = new AHRS(SPI.Port.kMXP, (byte) (200));

  public Sensors() {
    super();
		while (this.ahrs.isCalibrating()) {
			; // Calibrating NavX
		}
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
