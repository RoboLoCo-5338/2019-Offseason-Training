/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;  //import talons

import edu.wpi.first.wpilibj.command.Subsystem; //import commands
import frc.robot.OI;  //import OI
import frc.robot.OI.Button; //import button
import frc.robot.Subsystems.Drivetrain; //import drivetrain
/**
 * Add your docs here.
 */
public class WheelShooter extends Subsystem { //open class

  public final WPI_TalonSRX WHEEL_SHOOTER = new WPI_TalonSRX(4); // TODO: change Talon ID
 
public void wheel(OI oi) { //open wheel method
  if(oi.get(OI.Button.BUTTONA)) { //open if
  WHEEL_SHOOTER.set(1); 
  }//close if
  else {  //open else
    WHEEL_SHOOTER.set(0);
  } //end else
} //end wheel method


  @Override
  public void initDefaultCommand() {  //open DefaultCommand
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  } //end DefaultCommand
  /*if(oi.get(OI.Button.BUTTONB)){
Button.BUTTONB.whenPressed(WHEEL_SHOOTER.set(0));
}
}
*/
} //end class
