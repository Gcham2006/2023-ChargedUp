// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensor extends SubsystemBase {
  ////Sets up communication with TalonSRX which allows communication to PigeonIMU////
  public WPI_TalonSRX talon = new WPI_TalonSRX(8);
  public WPI_PigeonIMU pigeonIMU = new WPI_PigeonIMU(talon);

  //Creates a double array (A big list of spots to be filled with data). Contains exactly 3 spots.
  public double[] ypr_deg = new double[3];

  /** Creates a new Sensor. */
  public Sensor() {
    pigeonIMU.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
