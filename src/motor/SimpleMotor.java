package simplemotor.motor;

import simplemotor.motor.config.SimpleMotorConfig;
import simplemotor.motor.measurements.Measurements;
import simplemotor.motor.requests.MotorRequest;
import simplemotor.motor.requests.PrimitivePercentRequest;
import simplemotor.motor.requests.StopRequest;

import java.util.Random;

public class SimpleMotor{
    private static Random motorStartPositionGen = new Random();
    private final Measurements measurements;

    private final SimpleMotorConfig config;

    private MotorRequest activeRequest;

    public SimpleMotor(SimpleMotorConfig config){

        this.config = config;

        measurements =  new Measurements(config.MAX_SPEED_ROTATIONS_PER_MINUTE);

        activeRequest = new StopRequest(measurements);

        // Randomize the motor start position to simulate the motor not being at zero 100% of the time
        measurements.positionRotations = motorStartPositionGen.nextDouble(0,1);
    }

    public void setPercentOutput(double percentOutput){
        activeRequest = new PrimitivePercentRequest(measurements, percentOutput);
        activeRequest.start();
        logNewPosition();
    }

    public void stop(){
        activeRequest = new StopRequest(measurements);
        activeRequest.start();
        logNewPosition();
    }


    public void logNewPosition(){
        System.out.println(measurements.positionRotations - (
                config.zeroOffset.isPresent() ? config.zeroOffset.get().getRotations() : 0)
        );
        System.out.println(measurements.velocityRPM);
    }

    public void update(double timePassedSeconds){
        activeRequest.update(timePassedSeconds);
        logNewPosition();
    }
}