/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Commands.shootCommand;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final WPI_TalonSRX shootingMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX gate = new WPI_TalonSRX(4);
  boolean isToggled = false;
  double shootingSpeed = 0.0;

  public void shoot(OI oi){
    shootingSpeed = oi.getShootAxis(3);
    shootingMotor.set(shootingSpeed);
  }
  public void openGate(OI oi){
    if(oi.get(OI.Button.gateButton)){
      isToggled = !isToggled;
      if(isToggled){
        shootingSpeed = 0.3;
      }
      else{
        shootingSpeed = 0;
      }
      gate.set(shootingSpeed);
    }
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new shootCommand());
  }
}
