
package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class out extends Command{
    
    public out(){
        addRequirements(RobotContainer.Climber);
    }
    public void execute(){
        RobotContainer.Climber.set(0.4);
    }
    public void end(){
    }
}
