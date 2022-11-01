package agh.ics.oop;

import java.util.ArrayList;
public class World {
    public static void run(Enum[] args)
    {
        for(Enum argument : args)
        {
            if (argument == Direction.FORWARD){
                System.out.println("Zwierzak idzie do przodu");
            }
            if (argument == Direction.BACKWARD){
                System.out.println("Zwierzak idzie do tyłu");
            }
            if (argument == Direction.RIGHT){
                System.out.println("Zwierzak skręca w prawo");
            }
            if (argument == Direction.LEFT){
                System.out.println("Zwierzak skręca w lewo");
            }
        }


    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println("system zakończył działanie");
    }


}

