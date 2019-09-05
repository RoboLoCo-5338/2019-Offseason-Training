/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.OI.Button;
import frc.robot.Subsystems.Drivetrain;
/**
 * Add your docs here.
 */
public class WheelShooter extends Subsystem {
 
public void wheel(OI oi) {
  if(oi.get(OI.Button.BUTTONA)) { //oi.get is method
   // Button.BUTTONA.whenPressed(LEFT_1.set(1));
  }
if(oi.get(OI.Button.BUTTONB)){
  //  Button.BUTTONB.whenPressed(LEFT_2.set(1));
}
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
