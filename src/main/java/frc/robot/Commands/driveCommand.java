/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class driveCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public driveCommand() {
  
    requires(Robot.drivetrain);
    requires(Robot.sensors);

    this.addSequential(new driveForward(1.0));
    //Testing VS Code Git

    

  }
}
