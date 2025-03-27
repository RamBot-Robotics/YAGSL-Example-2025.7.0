
package frc.robot.commands.Algae.Effector;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class Intake extends Command{
    
    public Intake(){
        addRequirements(RobotContainer.Climber);
    }
    public void execute(){
        RobotContainer.Climber.set(-1);
    }
    public void end(){
        RobotContainer.Climber.set(0);  
    }
}
