package simplemotor;

import simplemotor.motor.SimpleMotor;
import simplemotor.motor.config.SimpleMotorConfig;
import simplemotor.utils.units.Angle;

import java.util.Optional;

public class Main{
    public static void main(String[] args){
        SimpleMotorConfig config = new SimpleMotorConfig();

        config.MAX_SPEED_ROTATIONS_PER_MINUTE = 60 * 60;
        config.zeroOffset = Optional.of(Angle.kZero);

        SimpleMotor motor = new SimpleMotor(config);

        motor.setPercentOutput(0.5);

        for (int i = 0; i < 60; i++){
            motor.update(1);
        }
    }
}