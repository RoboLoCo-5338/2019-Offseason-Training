/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Commands.shootCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  

  //change talon ids
  public final WPI_TalonSRX gateTalon = new WPI_TalonSRX(2);
  public final WPI_TalonSRX shooterTalon = new WPI_TalonSRX(4);

  boolean gateTogg = false;
  boolean shootTogg = false;
  double gateSpeed = 0.0;
  double shootSpeed = 0.0;

  public void shootBalls(OI oi) {
  
    // if(oi.get(OI.Button.shooter)) {
    //   shooterTalon.set(0.9);
    // } else {
    //   shooterTalon.set(0.0);
    // }

    SmartDashboard.putBoolean("button pressed", gateTogg);


    if(oi.get(OI.Button.gate)) {
      gateTogg = !gateTogg;
    }
    
    if(gateTogg) {
      gateSpeed = 1.0;
    }
    else{
      gateSpeed = 0.0;
    }

    gateTalon.set(gateSpeed);
    shooterTalon.set(gateSpeed);
  
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new shootCommand());
  }
}
