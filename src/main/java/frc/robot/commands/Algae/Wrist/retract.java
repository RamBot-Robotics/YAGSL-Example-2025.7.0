
package frc.robot.commands.Algae.Wrist;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.Constants.wrist;

public class retract extends InstantCommand{
    
    public retract(){
        addRequirements(RobotContainer.Climber);
    }
    public void execute(){
        RobotContainer.Algae.wristSetpoint(wrist.retract_point);
    }
}
