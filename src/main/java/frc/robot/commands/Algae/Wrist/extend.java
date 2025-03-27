
package frc.robot.commands.Algae.Wrist;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.Constants.wrist;

public class extend extends InstantCommand{
    
    public extend(){
        addRequirements(RobotContainer.Algae);
    }
    public void execute(){
        RobotContainer.Algae.wristSetpoint(wrist.extend_point);
    }
}
