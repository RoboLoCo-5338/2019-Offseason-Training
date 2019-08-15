/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class OI {

    // Create joysticks
    private static final Joystick leftController = new Joystick(0);
    //private static final Joystick rightController = new Joystick(0);

    // Create enum for different buttons
    public enum Button {
        buttonA, buttonB
    }

    public boolean get(final Button button) {
        switch (button) {
        case buttonA:
            
            return leftController.getRawButtonReleased(5);

        case buttonB:
            return leftController.getRawButton(1);

        default:
            return false;
        }
    }

    // Public method that returns the left joystick's deadzone-adjusted values
    public double getLeftJoystick(final char input) {
        switch (input) {
        case 'X': // Gets deadzone corrected x-axis position
            return (leftController.getRawAxis(0));
        case 'Y': // Gets deadzone corrected y-axis position
            return -(leftController.getRawAxis(1));
        case 'Z': // Gets deadzone corrected z-axis (rotation) position
            return 0.0;
        default: // Returns 0.0 is argument is unknown
            return 0.0;
        }
    }

    // Public method that returns the right joystick's deadzone-adjusted values
    public double getRightJoystick(final char input) {
        switch (input) {
        case 'X': // Gets deadzone corrected x-axis position
            return (leftController.getRawAxis(4));
        case 'Y': // Gets deadzone corrected y-axis position
            return -(leftController.getRawAxis(5));
        case 'Z': // Gets deadzone corrected z-axis (rotation) position
            return 0.0;
        default: // Returns 0.0 is argument is unknown
            return 0.0;
        }
    }

}
