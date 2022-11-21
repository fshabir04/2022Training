package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Inputs.*;
import static 

public class DrivetrainSubSys extends SubsystemBase {
 private static final CANSparkMax right1 = new CANSparkMax(deviceId: 1, MotorType.kBrushLess);
 private static final CANSparkMax right2 = new CANSparkMax(deviceId: 2, MotorType.kBrushLess);
 private static final CANSparkMax left1 = new CANSparkMax(deviceId: 3, MotorType.kBrushLess);
 private static final CANSparkMax left2 = new CANSparkMax(deviceId: 4, MotorType.kBrushLess);

 private static final MotorControllerGroup right = new MotorControllerGroup(right1, right2);
 private static final MotorControllerGroup left = new MotorControllerGroup(left1, left2);

 private static final DifferentalDrive difDrive = new DifferentalDrive(left, right);

    public DrivetrainSubSys() {
      difDrive.setSafetyEnabled(enabled: false);

      final int defenseCurrentLimit = 50;

      right1.setSmartCurrentLimit(defenseCurrentLimit);
      right2.setSmartCurrentLimit(defenseCurrentLimit);
      left1.setSmartCurrentLimit(defenseCurrentLimit);
      left2.setSmartCurrentLimit(defenseCurrentLimit);

    }

    public static void drv(double speed, double turn){
      difDrive.arcadeDrive(speed, turn);
    }

    public static void drive() {
      double speed = getDriveSpeed();

      if getSlowSpeed(){
        speed *= slowspeed;
      } else if (getMidSpeed()){
        speed *= midspeed;
        }
        else{
          //leave speed at max
      }
      drv(speed, getTurn()*turnspeed);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
