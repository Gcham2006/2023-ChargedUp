// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Sensor;

public class Balance extends CommandBase { 
  private DriveTrain driveTrain = null; 
  private Sensor sensor = null;

  /**
   * Creates a new Balance.
   * 
   * @param driveTrain Used to controller the drive train directly
   * @param sensor Used to get sensor values
   */
  public Balance(DriveTrain driveTrain, Sensor sensor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
    this.sensor = sensor;
    addRequirements(driveTrain, sensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    // Retrieves current yaw, pitch, and roll in spots 0, 1, 2 respectively
    sensor.pigeonIMU.getYawPitchRoll(sensor.ypr_deg);
    
    //Note*//
    //System.out.println("Yaw deg " + sensor.ypr_deg[0]);
    //This works as intended

    //System.out.println("Roll deg " + sensor.ypr_deg[1]); 
    //Documentation states that ypr_deg[1] is Pitch but for practical purposes it is our Roll

    //System.out.println("Pitch deg " + sensor.ypr_deg[2]);
    //System.out.println(sensor.ypr_deg[2]);
    //Documentation states that ypr_deg[2] is Roll but for practical purposes it is our Pitch

    /* This code activates the auto-balance */

    //This eases the movespeed according to the pitch's magnitude
    double moveSpeed = Math.abs(sensor.ypr_deg[2])/40;
    //This code limits the speed of the auto-balance
    if (moveSpeed > .35){
      moveSpeed = .35;
    }

    if (sensor.ypr_deg[2] < 2){
      driveTrain.arcadeDrive(moveSpeed, 0);
    }
    else if (-2 < sensor.ypr_deg[2]) {
      driveTrain.arcadeDrive(-moveSpeed, 0);
    }
    else {
      driveTrain.arcadeDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
