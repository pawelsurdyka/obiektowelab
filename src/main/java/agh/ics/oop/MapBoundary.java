package agh.ics.oop;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MapBoundary implements IPositionChangeObserver{
    List<Object> objectsX = new ArrayList<>();
    List<Object> objectsY = new ArrayList<>();
    void putObject(Object object){
        objectsX.add(object);
        objectsY.add(object);
    }

    Vector2d getlowerLeft(){
        Collections.sort(objectsX,new cartOrdX());
        Collections.sort(objectsY,new cartOrdY());
        if((objectsX.get(0) instanceof Animal || objectsX.get(0) instanceof Grass) && (objectsY.get(0) instanceof Animal || objectsY.get(0) instanceof Grass))
            return new Vector2d(((IMapElement) objectsX.get(0)).getPosition().x,((IMapElement) objectsY.get(0)).getPosition().y);
        else
            throw new IllegalArgumentException("lowerLeft untypical");
    }
    Vector2d getupperRight(){
        Collections.sort(objectsX,new cartOrdX());
        Collections.sort(objectsY,new cartOrdY());
        int end = objectsX.size()-1;
        if((objectsX.get(end) instanceof Animal || objectsX.get(end) instanceof Grass) && (objectsY.get(end) instanceof Animal || objectsY.get(end) instanceof Grass))
            return new Vector2d(((IMapElement) objectsX.get(end)).getPosition().x,((IMapElement) objectsY.get(end)).getPosition().y);
        else
            throw new IllegalArgumentException("upperRight untypical");
    }
    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        return false;
    }
}

class cartOrdX implements Comparator<Object> {
    public int compare(Object a, Object b){
        if((a instanceof Animal || a instanceof Grass) && (b instanceof Animal || b instanceof Grass)){
            if(((IMapElement) a).getPosition().x==((IMapElement) b).getPosition().x){
                if(((IMapElement) a).getPosition().y==((IMapElement) b).getPosition().y){
                    if(a instanceof Animal)
                        return -1;
                    else
                        return 1;
                }
                else
                    return ((IMapElement) a).getPosition().y-((IMapElement) b).getPosition().y;
            }
            else
                return ((IMapElement) a).getPosition().x-((IMapElement) b).getPosition().x;
        }
        return 0;
    }
}

class cartOrdY implements Comparator<Object> {
    public int compare(Object a, Object b){
        if((a instanceof Animal || a instanceof Grass) && (b instanceof Animal || b instanceof Grass)){
            if(((IMapElement) a).getPosition().y==((IMapElement) b).getPosition().y){
                if(((IMapElement) a).getPosition().x==((IMapElement) b).getPosition().x){
                    if(a instanceof Animal)
                        return -1;
                    else
                        return 1;
                }
                else
                    return ((IMapElement) a).getPosition().x-((IMapElement) b).getPosition().x;
            }
            else
                return ((IMapElement) a).getPosition().y-((IMapElement) b).getPosition().y;
        }
        return 0;
    }
}