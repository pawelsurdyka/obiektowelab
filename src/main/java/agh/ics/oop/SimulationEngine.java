package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    ArrayList<MoveDirection> moves;
    IWorldMap map;
    Vector2d[] startposition;
    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] startposition2){
        this.moves = moves;
        this.map = map;
        this.startposition = startposition2;
        addAnimals();
    }
    public void addAnimals() {
        for (Vector2d ps : startposition) {
            map.place(new Animal(map, ps));
        }
    }

    public void run(){
        int i=0;
        RectangularMap rmap = (RectangularMap) map;
        List<Animal> A = rmap.getA();
        System.out.println(rmap);
        for(MoveDirection move:moves){
            A.get(i).move(move);
            i+=1;
            i%=A.size();
        }
        map = rmap;
    }
}