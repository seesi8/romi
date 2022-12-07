// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExternalIO;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;


public class ArmCommand extends CommandBase {
    private final ExternalIO m_externalIO;
    private final Supplier<Double> m_liftSupplier;
    private final Supplier<Double> m_tiltSupplier;


    public ArmCommand(ExternalIO m_externalIO, Supplier<Double> m_liftSupplier, Supplier<Double> m_tiltSupplier,
    Supplier<Double> m_jawsSupplier) {
        this.m_externalIO = m_externalIO;
        this.m_liftSupplier = m_liftSupplier;
        this.m_tiltSupplier = m_tiltSupplier;
        this.m_jawsSupplier = m_jawsSupplier;
    }

    private final Supplier<Double> m_jawsSupplier;


  @Override
  public void execute() {
   // this is a boolean because its prob more simple when coding and we never need to have it half open or smth
   m_externalIO.m_servo2.set(m_jawsSupplier.get());
   m_externalIO.m_servo3.set(m_liftSupplier.get());
   m_externalIO.m_servo4.set(m_tiltSupplier.get());
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
