package agh.ics.oop;

import java.util.ArrayList;

public class Animal implements IMapElement{
    private MapDirection dir = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;
    public ArrayList<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
//        addObserver(observer);
    }
    public Vector2d getPosition(){return position;}
    public void setPos(Vector2d pos){position=pos;}
    public MapDirection getDir(){
        return dir;
    }
    public String toString(){
        if(dir==MapDirection.NORTH) return "^";
        if(dir==MapDirection.EAST) return ">";
        if(dir==MapDirection.SOUTH) return "v";
        return "<";
    }
    public void move(MoveDirection direction){
        Vector2d oldPosition = position;
        Vector2d add = dir.toUnitVector();
        switch(direction){
            case LEFT:
                dir=dir.previous();
                break;
            case RIGHT:
                dir=dir.next();
                break;
            case FORWARD:
                if(map.canMoveTo(position.add(add))) {
                    position = position.add(add);
                    this.positionChanged(oldPosition, this.position);
                }
                break;
            case BACKWARD:
                if(map.canMoveTo(position.subtract(add))) {
                    position = position.subtract(add);
                    this.positionChanged(oldPosition, this.position);
                }
                break;
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver obs:observers){
            obs.positionChanged(oldPosition, newPosition);
        }
    }
}