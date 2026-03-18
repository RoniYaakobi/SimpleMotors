package simplemotor;

import simplemotor.motor.SimpleMotor;

public class Main{
    public static void main(String[] args){
        SimpleMotor motor = new SimpleMotor(360,0,
                0.2,false);

        motor.update(0.5);
    }
}