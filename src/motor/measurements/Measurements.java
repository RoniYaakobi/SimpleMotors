package simplemotor.motor.measurements;

public class Measurements{

    public final double MAX_SPEED_ROTATIONS_PER_MINUTE;
    public double positionRotations;
    public double velocityRPM;

    public Measurements(double MAX_SPEED_ROTATIONS_PER_MINUTE){
        this.MAX_SPEED_ROTATIONS_PER_MINUTE = MAX_SPEED_ROTATIONS_PER_MINUTE;
    }
}
