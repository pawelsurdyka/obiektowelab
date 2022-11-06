package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassFieldTest {
    @Test
    public void GrassFieldTest1() {
        String[] S = {"b","f", "b" ,"f", "b" ,"f","b","f", "b" ,"f", "b" ,"f","l","r","f","f","f","f"
                ,"f","f","f","f","f","f","f","f"};
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        AbstractWorldMap map = new GrassField(5);
        Vector2d[] positions = {new Vector2d(2, 3), new Vector2d(3, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<String> s = new ArrayList<>();
        s.add("<");
        s.add(">");
        assertEquals( map.getA().toString(),s.toString());
        assertEquals( map.getG().size(),5);
        assertEquals( map.lowerLeft(),new Vector2d(-5, -4));
        assertEquals( map.upperRight(),new Vector2d(10, 9));
    }
    @Test
    public void GrassFieldTest2() {
        String[] S = {"b","f", "b" ,"f", "b" ,"f","b","f", "b" ,"f", "b" ,"f","l","r","f","f","f","f"
                ,"f","f","f","f","f","f","f","f"};
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 3), new Vector2d(4, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<String> s = new ArrayList<>();
        s.add("<");
        s.add(">");
        assertEquals( map.getA().toString(),s.toString());
        assertEquals( map.getG().size(),10);
        assertEquals( map.lowerLeft(),new Vector2d(-5, -4));
        assertEquals( map.upperRight(),new Vector2d(11, 11));
    }
}