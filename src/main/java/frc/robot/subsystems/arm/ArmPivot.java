package frc.robot.subsystems.arm;

import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmPivot extends SubsystemBase {
    public final TalonFX armPivot;
    private final PositionVoltage armPosition = new PositionVoltage(0);

    public ArmPivot() {
        armPivot = new TalonFX(ArmConfigs.MOTOR_1_ID, CANBus.roboRIO("Arm_CANBus"));
        armPivot.getConfigurator().apply(ArmConfigs.WRIST_CONFIGS);
    }

    public Command pivotPosition(double currentPosition) {
        return runOnce(() -> armPivot.setControl(armPosition.withPosition(currentPosition)));
    }

    public Command toggle() {
        if(armPivot.getPosition().getValueAsDouble()>0.5) {
            return pivotPosition(1);
        } else{
            return pivotPosition(0);
        }
    }
}
