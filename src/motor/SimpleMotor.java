package simplemotor.motor;
public class SimpleMotor{
    private double percentOutput;
    private double position;
    private final double MAX_SPEED_DEGREES_PER_SECOND;
    private boolean logWrappedAround;

    public SimpleMotor(double MAX_SPEED_DEGREES_PER_SECOND, double startingPosition,
                       double percentOutput, boolean logWrappedAround){

        this.MAX_SPEED_DEGREES_PER_SECOND = MAX_SPEED_DEGREES_PER_SECOND;
        this.percentOutput = percentOutput;
        position = startingPosition;
        this.logWrappedAround = logWrappedAround;
    }

    public void setPercentOutput(double percentOutput){
        this.percentOutput = percentOutput;
    }

    public void setLogMode(boolean logWrappedAround){
        this.logWrappedAround = logWrappedAround;
    }

    public void calculateNewPosition(double timePassedSeconds){
        position += MAX_SPEED_DEGREES_PER_SECOND * percentOutput * timePassedSeconds;
    }

    public void logNewPosition(){
        if (logWrappedAround) {
            System.out.println(position % 360);
        } else {
            System.out.println(position);
        }
    }

    public void update(double timePassedSeconds){
        calculateNewPosition(timePassedSeconds);
        logNewPosition();
    }
}