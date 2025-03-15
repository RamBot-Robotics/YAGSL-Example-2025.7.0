package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.sim.CANcoderSimState;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.climber;

public class Climber extends SubsystemBase{

  public SparkMax mclimber = new SparkMax(climber.id, climber.neo);
  public CANcoder encoderL = new CANcoder(climber.encoderid);
  
  PIDController kPID = new PIDController(climber.Kp, climber.Ki, climber.Kd);

  int rEncoderDistance;
  double speedL;
  double speedR;
    public void setup(){
        mclimber.clearFaults();
        mclimber.configure(climber.config,0,0);
        mclimber.setSmartCurrentLimit(climber.current);
        
      }

    public void set(double input_speed){
      double speedL = input_speed * climber.power;
      mclimber.set(speedL);
    }

    public void goSet(double setpoint){
      //sets modEncoderX to be a number where 0 is the bottom of the climber's state and 1 is the top
      double modEncoderL = encoderL.getPosition().getValueAsDouble()/climber.ConversionRate; 
      mclimber.set(kPID.calculate(encoderL.getPosition().getValueAsDouble(), setpoint));
      SmartDashboard.putNumber("Climber/climber/Setpoint", setpoint);
      SmartDashboard.putNumber("Climber/climber/Setpoint", setpoint);
    }

    
    //basically ram the climber into itself until it stops repeatedly to determine zero point for cancoders
    //somewhat like a prusa 3d printer
    public void zero(){
      int attempts = 2; 
      mclimber.set(-1);
      while (!(attempts==0)) {

        boolean LeftZero = false;
        boolean RightZero = false;

      while (!LeftZero || !RightZero){


      if (mclimber.getEncoder().getVelocity() < 300){ 
        encoderL.setPosition(0);
        mclimber.set(0);
        LeftZero = true;

        mclimber.set(-1);
     

     attempts--;
      mclimber.set(kPID.calculate(encoderL.getPosition().getValueAsDouble(), 1000));

     
    }
  }
    public void setInd(double input_speedL, double input_speedR){
      double speedL = input_speedL * climber.power;
      mclimber.set(speedL);
    }
}