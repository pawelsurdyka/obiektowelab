package agh.ics.oop;


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
        int l = args.length;
        Enum[] arr;
        arr = new Enum[l];
        for (int i = 0; i < args.length; i+=1)
        {
            switch (args[i]) {
                case "f":
                    arr[i] = Direction.FORWARD;
                    break;
                case "b":
                    arr[i] = Direction.BACKWARD;
                    break;
                case "r":
                    arr[i] = Direction.RIGHT;
                    break;
                case "l":
                    arr[i] = Direction.LEFT;
                    break;
            }
        }
        System.out.println("system wystartował");
        int x = 1;
        int y = 2;
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.equals(position2));
        MapDirection Direction = MapDirection.EAST;
        System.out.println(Direction.toUnitVector());
        run(arr);
        System.out.println("system zakończył działanie");
    }


}

