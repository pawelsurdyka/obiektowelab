package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        String s = "(" + Integer.toString(position.x) + "," + Integer.toString(position.y) + ")";
        switch (direction) {
            case NORTH:
                return s + " NORTH";
            case SOUTH:
                return s + " SOUTH";
            case EAST:
                return s + " EAST";
            case WEST:
                return s + " WEST";
            default:
                return "zła dana";
        }
    }

    public boolean isAt(Vector2d position2) {
        if (position.x == position2.x && position.y == position2.y) {
            return true;
        }
        return false;
    }

    public String move(MoveDirection direction2) {
        switch (direction){
            case NORTH:
                switch (direction2){
                    case RIGHT:
                        direction = MapDirection.EAST;
                        break;
                    case LEFT:
                        direction = MapDirection.WEST;
                        break;
                    case FORWARD:
                        if (position.y < 4){
                            position.y += 1;
                        }
                        break;
                    case BACKWARD:
                        if (position.y > 0){
                            position.y -= 1;
                        }
                        break;
                }
                break;
            case SOUTH:
                switch (direction2){
                    case RIGHT:
                        direction = MapDirection.WEST;
                        break;
                    case LEFT:
                        direction = MapDirection.EAST;
                        break;
                    case FORWARD:
                        if (position.y > 0){
                            position.y -= 1;
                        }
                        break;
                    case BACKWARD:
                        if (position.y < 4){
                            position.y += 1;
                        }
                        break;
                }
                break;
            case EAST:
                switch (direction2){
                    case RIGHT:
                        direction = MapDirection.SOUTH;
                        break;
                    case LEFT:
                        direction = MapDirection.NORTH;
                        break;
                    case FORWARD:
                        if (position.x < 4){
                            position.x += 1;
                        }
                        break;
                    case BACKWARD:
                        if (position.x > 0){
                            position.x -= 1;
                        }
                        break;
                }
                break;
            case WEST:
                switch (direction2){
                    case RIGHT:
                        direction = MapDirection.NORTH;
                        break;
                    case LEFT:
                        direction = MapDirection.SOUTH;
                        break;
                    case FORWARD:
                        if (position.x > 0){
                            position.x -= 1;
                        }
                        break;
                    case BACKWARD:
                        if (position.x < 4){
                            position.x += 1;
                        }
                        break;
                }
                break;
        }
        return toString();
    }

}