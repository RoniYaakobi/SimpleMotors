package simplemotor.motor.config;

import simplemotor.utils.units.Angle;

import java.util.Optional;

public class SimpleMotorConfig {
    /**
     * The fastest speed the motor can reach.
     */
    public double MAX_SPEED_ROTATIONS_PER_MINUTE;

    /**
     * An offset to subtract from the motor position which gives you a new zero position
     * For example if the encoder reads 30 degrees where you want to define 0, this will be
     * 30 degrees. Notice that not all sensors subtract.
     */
    public Optional<Angle> zeroOffset;

}
