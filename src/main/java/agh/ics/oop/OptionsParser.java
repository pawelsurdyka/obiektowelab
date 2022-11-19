package agh.ics.oop;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(List<String> args){
        ArrayList<MoveDirection>A=new ArrayList<>();
        for(String arg:args){
            switch (arg) {
                case "f","forward":
                    A.add(MoveDirection.FORWARD);
                    break;
                case "b", "backward":
                    A.add(MoveDirection.BACKWARD);
                    break;
                case "r", "right":
                    A.add(MoveDirection.RIGHT);
                    break;
                case "l", "left":
                    A.add(MoveDirection.LEFT);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return A;
    }
}