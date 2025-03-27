package frc.robot.subsystems;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkClosedLoopController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class Algae extends SubsystemBase{

  public SparkMax mWrist = new SparkMax(wrist.id, wrist.neo);  
  public SparkMax mEffector = new SparkMax(effector.id, effector.neo);  


SparkClosedLoopController m_controller = mWrist.getClosedLoopController();

    public void periodic(){
      
    }
    public void setup(){
        mWrist.clearFaults();
        SparkBaseConfig confWrist = new SparkMaxConfig();
        confWrist.idleMode(IdleMode.kBrake);
        mWrist.configure(confWrist,SparkBase.ResetMode.kNoResetSafeParameters,PersistMode.kNoPersistParameters);


        mEffector.clearFaults();
        SparkBaseConfig confEffector = new SparkMaxConfig();
        confEffector.idleMode(IdleMode.kBrake);
        mEffector.configure(confEffector,SparkBase.ResetMode.kNoResetSafeParameters,PersistMode.kNoPersistParameters);


      }

    public void effectorSet(double input_speed){
      double speed = input_speed * climber.power;
      mEffector.set(speed);
    }
    public void wristSetpoint(double input_setpoint){
      m_controller.setReference(input_setpoint, ControlType.kPosition);

    }
    
   

}