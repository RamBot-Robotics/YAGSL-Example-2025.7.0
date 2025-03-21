
package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class in extends Command{
    
    public in(){
        addRequirements(RobotContainer.Climber);
    }
    public void execute(){
        RobotContainer.Climber.set(-1);
    }
    public void end(){
        RobotContainer.Climber.set(0);  
    }
}
