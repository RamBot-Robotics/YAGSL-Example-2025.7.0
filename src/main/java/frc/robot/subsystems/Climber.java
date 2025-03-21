package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.sim.CANcoderSimState;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.climber;

public class Climber extends SubsystemBase{

  public SparkMax mclimber = new SparkMax(climber.id, climber.neo);  
  

  PIDController kPID = new PIDController(climber.Kp, climber.Ki, climber.Kd);

  int rEncoderDistance;
  double speedL;
    public void setup(){
        mclimber.clearFaults();
        SparkBaseConfig config = new SparkMaxConfig();
        config.idleMode(IdleMode.kBrake);
        mclimber.configure(config,SparkBase.ResetMode.kNoResetSafeParameters,PersistMode.kNoPersistParameters);
        mclimber.getEncoder().getPosition();


      }

    public void set(double input_speed){
      double speedL = input_speed * climber.power;
      mclimber.set(speedL);
    }

    public void goSet(double setpoint){
      //sets modEncoderX to be a number where 0 is the bottom of the climber's state and 1 is the top
      double modEncoderL = mclimber.getEncoder().getPosition()/climber.ConversionRate; 
      mclimber.set(kPID.calculate(mclimber.getEncoder().getPosition(), setpoint));
      SmartDashboard.putNumber("Climber/climber/Setpoint", setpoint);
      SmartDashboard.putNumber("Climber/climber/Setpoint", setpoint);
    }

    
    //basically ram the climber into itself until it stops repeatedly to determine zero point for cancoders
    //somewhat like a prusa 3d printer
   

    public void setInd(double input_speedL, double input_speedR){
      double speedL = input_speedL * climber.power;
      mclimber.set(speedL);
    }
}