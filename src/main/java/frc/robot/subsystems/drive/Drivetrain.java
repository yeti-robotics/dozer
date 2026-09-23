package frc.robot.subsystems.drive;

import static frc.robot.subsystems.drive.DrivetrainConfigs.DRIVE_MOTOR_CURRENT_LIMIT;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Drivetrain extends SubsystemBase {
    private final TalonFX leftLeader;
    private final TalonFX rightLeader;
    private final TalonFX leftFollower;
    private final TalonFX rightFollower;

    public Drivetrain() {
        leftLeader = new TalonFX(DrivetrainConfigs.LEFT_LEADER_ID, Constants.rioBus);
        rightLeader = new TalonFX(DrivetrainConfigs.RIGHT_LEADER_ID, Constants.rioBus);
        leftFollower = new TalonFX(DrivetrainConfigs.LEFT_FOLLOWER_ID, Constants.rioBus);
        rightFollower = new TalonFX(DrivetrainConfigs.RIGHT_FOLLOWER_ID, Constants.rioBus);

        rightLeader.setControl(new Follower(DrivetrainConfigs.RIGHT_FOLLOWER_ID, MotorAlignmentValue.Aligned));
        leftLeader.setControl(new Follower(DrivetrainConfigs.LEFT_FOLLOWER_ID, MotorAlignmentValue.Aligned));
    }

    @Override
    public void periodic() {}

    public void driveTank(double leftSpeed, double rightSpeed) {
        leftLeader.set(leftSpeed);
        rightLeader.set(rightSpeed);
    }
}