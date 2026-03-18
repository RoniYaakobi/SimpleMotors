package simplemotor.motor.requests;

import simplemotor.motor.SimpleMotor;
import simplemotor.motor.measurements.Measurements;

public abstract class MotorRequest {

    protected final Measurements motorMeasurements;

    protected MotorRequest(Measurements motorMeasurements){
        this.motorMeasurements = motorMeasurements;
    }
    /**
     * Updates a measurements object to newly calculated measurements
     * @param timePassedSeconds how long has been since the last step in the simulation
     */
    public abstract void update(double timePassedSeconds);

    /**
     * Activate the MotorRequest
     */
    public abstract void start();
}
