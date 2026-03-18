package simplemotor.motor.requests;

import simplemotor.motor.measurements.Measurements;

public class PrimitivePercentRequest extends MotorRequest{

    private double percent;

    public PrimitivePercentRequest(Measurements motorMeasurements, double percent){
        super(motorMeasurements);
        this.percent = percent;
    }

    @Override
    public void update(double timePassedSeconds) {
        motorMeasurements.positionRotations += motorMeasurements.velocityRPM * (timePassedSeconds / 60);
    }

    @Override
    public void start() {
        motorMeasurements.velocityRPM = motorMeasurements.MAX_SPEED_ROTATIONS_PER_MINUTE * percent;
    }
}
