package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        int l = args.length;
        MoveDirection[] arr;
        arr = new MoveDirection[0];
        for (int i = 0; i < l; i+=1)
        {
            switch (args[i]) {
                case "f":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.FORWARD;
                    break;
                case "b":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.BACKWARD;
                    break;
                case "r":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.RIGHT;
                    break;
                case "l":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.LEFT;
                    break;
                case "forward":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.FORWARD;
                    break;
                case "backward":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.BACKWARD;
                    break;
                case "right":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.RIGHT;
                    break;
                case "left":
                    arr = Arrays.copyOf(arr, arr.length + 1);
                    arr[arr.length - 1] = MoveDirection.LEFT;
                    break;
                default:
                    break;
            }
        }
        return arr;
    }
}
