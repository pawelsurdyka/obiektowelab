package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class SimulationEngine implements IEngine{
    ArrayList<MoveDirection> moves;
    IWorldMap map;
    Vector2d[] startpos;
    List<Animal> A;
    List<Grass> G;
    GrassField gmap;
    public List<Animal> getA(){
        return A;
    }
    public List<Grass> getG(){
        return G;
    }
    public Vector2d[] getBorder(){
        Vector2d[] Border = {gmap.bond.getlowerLeft(),gmap.bond.getupperRight()};
        return Border;
    }
    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] startpos){
        this.moves = moves;
        this.map = map;
        this.startpos = startpos;
        addAnimals();
    }
    public void addAnimals() {
        for (Vector2d ps : startpos) {
            map.place(new Animal(map, ps));
        }
    }
    @Override
    public void run(){
        int id=0;
        gmap = (GrassField) map;
        Map<Vector2d, Animal> animals = gmap.getAnimals();
        A = gmap.getA();
        G = gmap.getG();
        System.out.println(gmap);
        while(id<moves.size()){
//            for(Animal i:animals.values()){
            for(Animal i:A){
                if(id>=moves.size())
                    break;
                i.move(moves.get(id));
                System.out.println(moves.get(id));
                System.out.println(i);
                System.out.println(id);
                System.out.println(gmap);
                id+=1;
            }
        }
        map = gmap;
    }
}