package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.direction=MapDirection.NORTH;
        this.map=map;
        this.position=initialPosition;
    }
    public Vector2d getPos(){
        return position;
    }
    public void setPos(Vector2d pos){
        position=pos;
    }
    public MapDirection getDirection(){
        return direction;
    }
    public String toString(){
        switch (direction) {
            case NORTH:
                return "^";
            case SOUTH:
                return "v";
            case EAST:
                return ">";
            case WEST:
                return "<";
            default:
                return "zła dana";
        }
    }
    public void move(MoveDirection direction2){
        Vector2d add = direction.toUnitVector();
        switch(direction2){
            case LEFT:
                direction=direction.previous();
                break;
            case RIGHT:
                direction=direction.next();
                break;
            case FORWARD:
                if(map.canMoveTo(position.add(add)))
                    position=position.add(add);
                break;
            case BACKWARD:
                if(map.canMoveTo(position.subtract(add)))
                    position=position.subtract(add);
                break;
        }
    }

}