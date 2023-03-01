// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static CommandBase testAuto(Drivetrain drivetrain, double apriltagid){
    if (apriltagid == 1 || apriltagid == 8) {
      return Commands.sequence(
        //turn around 180degrees
        //drive forwards 16 ft
        //claw open
        //claw down
        //drive forward 2 ft
        //claw close
        //claw up 
        //turn left 90 degrees
        //forward about 4 ft
        //turn left 90 degrees 
        //forward forward 18 ft
        //claw open
      );
  } 
    else if (apriltagid == 2 || apriltagid == 7) {
      return Commands.sequence(
        //turn around 180degrees
        //drive forwards 16 ft
        //turn right 90 degrees 
        // drive forward 4 feet
        //turn left90 degrees
        //claw open
        //claw down
        //driveforward 2 feet
        //claw close
        //claw up 
        //turn left 90 degrees
        //forward about 2 ft
        //turn left 90
        //drive forwards 18 feet
        //claw open
      );
  } 
    else if (apriltagid == 3 || apriltagid == 6) {
      return Commands.sequence(
        //turn around 180 degrees 
        //drive forward 16 ft
        //claw open
        //claw down
        //drive forward 2 ft
        //claw close
        //claw up 
        //turn left 90 degrees
        //drive forward 3 ft
        //turn left 90 degrees
        //drive forward 18 ft
        //claw open
      );
    }
  
    else{
          return Commands.sequence(
            new DriveDistance(50, 50, drivetrain),
            new DriveDistance(50, 50, drivetrain)
      );
  }
            }
    
    //)
    //return Commands.sequence(
      //new DriveDistance(50, 50, drivetrain),
      //new DriveDistance(-50, 50, drivetrain)
    //);
  

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }}

