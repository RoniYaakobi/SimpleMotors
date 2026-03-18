package simplemotor.motor.requests;

import simplemotor.motor.measurements.Measurements;

public class StopRequest extends MotorRequest{
    public StopRequest(Measurements motorMeasurements){
        super(motorMeasurements);

    }

    @Override
    public void update(double timePassedSeconds) {

    }

    @Override
    public void start() {
        motorMeasurements.velocityRPM = 0;
    }
}
