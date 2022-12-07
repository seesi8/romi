// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.RomiGyro;
import frc.robot.subsystems.OnBoardIO.ChannelMode;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExternalIO extends SubsystemBase {

    public DigitalInput m_input8;
    public DigitalInput m_input9;
    public DigitalOutput m_output8;
    public AnalogInput m_analogInput0;
    public DigitalOutput m_output9;
    public Servo m_servo2;
    public Servo m_servo3;
    public DigitalInput m_input10;
    public DigitalOutput m_output10;
    public Servo m_servo4;
    public AnalogInput m_analogInput1;

    public ExternalIO(ChannelMode ext0, ChannelMode ext1, ChannelMode ext2) {
    switch (ext0) {
        case DIO:
          if ( ext0 == ChannelMode.INPUT)
            m_input8 = new DigitalInput(8);
          else
            m_output8 = new DigitalOutput(8);
          break;
        case PWM : m_servo2 = new Servo(2); break;
          /* i dont know if this derverstation error works 
           * !!!!!!!!!!!
           * this is only for ext0 because it does support analog in!!! Do not do this anywhere else!!!
           * !!!!!!!!!!!
           */
        case AIN: DriverStation.reportError("Cannot configure EXT0 as Analog Input", true); break;
    }
    switch (ext1) {
        case DIO:
          if (ext1 == ChannelMode.INPUT)
            m_input9 = new DigitalInput(9);
          else
            m_output9 = new DigitalOutput(9);
          break;
          case PWM:   m_servo3 = new Servo(3); break;
          case AIN:   m_analogInput0 = new AnalogInput(0); break;
    }
    switch (ext2) {
        case DIO:
          if (ext1 == ChannelMode.INPUT)
            m_input10 = new DigitalInput(9);
          else
            m_output10 = new DigitalOutput(9);
          break;
          case PWM:   m_servo4 = new Servo(3); break;
          case AIN:   m_analogInput1 = new AnalogInput(0); break;
    }
  }
}
