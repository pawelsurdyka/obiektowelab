package agh.ics.oop;

import java.util.Arrays;
import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] args){
        ArrayList<MoveDirection>A=new ArrayList<>();
        for(String arg:args){
            switch (arg) {
                case "f":
                case "forward":
                    A.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    A.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                case "right":
                    A.add(MoveDirection.RIGHT);
                    break;
                case "l":
                case "left":
                    A.add(MoveDirection.LEFT);
                    break;
            }
        }
        return A;
    }
}