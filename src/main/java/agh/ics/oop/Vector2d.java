package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public int x;
    public int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        String s = "("+Integer.toString(x) +","+Integer.toString(y)+")";
        return s;
    }
    public boolean precedes(Vector2d other){
        if (x <= other.x && y <= other.y) {
            return true;
        }
        return false;
    }

    public boolean follows(Vector2d other){
        if (other.x <= x && other.y <= y) {
            return true;
        }
        return false;
    }

    public Vector2d add(Vector2d other){
        int a = x + other.x;
        int b = y + other.y;
        Vector2d positionadd = new Vector2d(a,b);
        return positionadd;
    }

    public Vector2d subtract(Vector2d other){
        int a = x - other.x;
        int b = y - other.y;
        Vector2d positionsub = new Vector2d(a,b);
        return positionsub;
    }

    public Vector2d upperRight(Vector2d other){
        int a = Math.max(x,other.x);
        int b = Math.max(y,other.y);
        Vector2d positionup = new Vector2d(a,b);
        return positionup;
    }

    public Vector2d lowerLeft(Vector2d other){
        int a = Math.min(x,other.x);
        int b = Math.min(y,other.y);
        Vector2d positionlow = new Vector2d(a,b);
        return positionlow;
    }
    public Vector2d opposite(){
        int a = -x;
        int b = -y;
        Vector2d positionlow = new Vector2d(a,b);
        return positionlow;
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return x == that.x && y == that.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

}
