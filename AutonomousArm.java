package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExternalIO;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousArm extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousArm(ExternalIO m_externalIO) {
    addCommands(  new ArmCommand(m_externalIO, m_liftSupplier, m_tiltSupplier, m_jawsSupplier));
  }
}