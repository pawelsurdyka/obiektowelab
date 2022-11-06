package agh.ics.oop;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private int grassNo;
    public GrassField(int n){
        boolean error;
        grassNo = n;
        int maxx = 0;
        int maxy = 0;
        for(int i=0; i<grassNo; i++){
            error = false;
            Random rand = new Random();
            int x = 0;
            int y = 0;
            while(!error) {
                error = true;
                x = rand.nextInt((int) Math.ceil(Math.sqrt(grassNo * 10)));
                y = rand.nextInt((int) Math.ceil(Math.sqrt(grassNo * 10)));
                for (Grass vec : grassMap) {
                    if (vec.getPosition().equals(new Vector2d(x, y))) {
                        error = false;
                    }
                }
                for (Animal an : animals) {
                    if (an.getPosition().equals(new Vector2d(x, y))) {
                        error = false;
                    }
                }
            }
            if(error) {
                grassMap.add(new Grass(new Vector2d(x, y)));
            }
        }
    }
    @Override
    public Vector2d lowerLeft() {
        int minx=Integer.MAX_VALUE;
        int miny=Integer.MAX_VALUE;
        for(Animal a:animals){
            minx = Math.min(minx,a.getPosition().x);
            miny = Math.min(miny,a.getPosition().y);
        }
        for(Grass g:grassMap){
            minx = Math.min(minx,g.getPosition().x);
            miny = Math.min(miny,g.getPosition().y);
        }
        return new Vector2d(minx-1, miny-1);
    }
    @Override
    public Vector2d upperRight() {
        int maxx=Integer.MIN_VALUE;
        int maxy=Integer.MIN_VALUE;
        for(Animal a:animals){
            maxx = Math.max(maxx,a.getPosition().x);
            maxy = Math.max(maxy,a.getPosition().y);
        }
        for(Grass g:grassMap){
            maxx = Math.max(maxx,g.getPosition().x);
            maxy = Math.max(maxy,g.getPosition().y);
        }
        return new Vector2d(maxx+1, maxy+1);
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animals.add(animal);
            return true;
        } else {
            Object object = objectAt(animal.getPosition());
            if (object instanceof Grass) {
                for (Grass grass : grassMap) {
                    if (grass.getPosition().x == animal.getPosition().x && grass.getPosition().y == animal.getPosition().y) {
                        break;
                    }
                }
                animals.add(animal);
            } else return false;
        }
        return false;
    }


}
