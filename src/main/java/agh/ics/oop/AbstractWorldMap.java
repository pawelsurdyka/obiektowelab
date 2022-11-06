package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<Animal>();
    protected List<Grass> grassMap = new ArrayList<Grass>();

    public abstract Vector2d upperRight();

    public abstract Vector2d lowerLeft();

    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeft(), upperRight());
    }

    public List<Animal> getA(){
        return animals;
    }

    public List<Grass> getG(){
        return grassMap;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        for (Grass grass : grassMap) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return false;
            }
        }
        return position.follows(lowerLeft()) && position.precedes(upperRight());

    }

    @Override
    public boolean place(Animal animal){
        if(!isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position))   return animal;
        }
        for(Grass grass:grassMap){
            if(grass.getPosition().equals(position))   return grass;
        }
        return null;
    }




}
