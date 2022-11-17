import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GrassFieldTest {
    @Test
    public void GrassFieldTest() {
        String[] S = {"f", "f", "r", "b", "f"};
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        GrassField map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(10, map.getG().size());
    }
    @Test
    public void PlaceTest(){
        boolean thrown = false;
        String e = "java.lang.IllegalArgumentException: (2,2) can't put animal at this position";
        String e2 = "ok";
        try{
            GrassField map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4),new Vector2d(-10, -5), new Vector2d(2, 2)};
            for(Vector2d p:positions){
                Animal animal = new Animal(map,p);
                map.place(animal);
            }
        } catch (IllegalArgumentException exception) {
            thrown = true;
            e2 = exception.toString();
        }
        assertTrue(thrown);
        assertEquals(e,e2);
    }
}