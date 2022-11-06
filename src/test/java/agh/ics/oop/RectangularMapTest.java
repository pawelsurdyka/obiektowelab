package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class RectangularMapTest{

    @Test
    public void RectangularMapTest1(){
        String[] S = {"f", "f" ,"r", "b" ,"f","b"};
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        AbstractWorldMap map = new RectangularMap();
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4),new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.runForRectangularMap();
        ArrayList<String> s = new ArrayList<>();
        s.add(">");
        s.add("^");
        assertEquals( map.getA().toString(),s.toString());
        assertEquals( map.getA().size(),2);
        assertEquals( map.lowerLeft(),new Vector2d(2, 2));
        assertEquals( map.upperRight(),new Vector2d(4, 5));

    }
    @Test
    public void RectangularMapTest2(){
        String[] S = {"l", "f" ,"r", "b" ,"f","b","b", "l" ,"r", "b" ,"f","b"};
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        AbstractWorldMap map = new RectangularMap();
        Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(0, 1),new Vector2d(1, 0),
                new Vector2d(1, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.runForRectangularMap();
        ArrayList<String> s = new ArrayList<>();
        s.add("^");
        s.add("^");
        s.add(">");
        s.add("<");
        assertEquals( map.getA().toString(),s.toString());
        assertEquals( map.getA().size(),4);
        assertEquals( map.lowerLeft(),new Vector2d(-2, -1));
        assertEquals( map.upperRight(),new Vector2d(3, 2));
    }


}
