import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularMapTest {
    @Test
    public void RectangularMapTest() {
        List<String> S = new ArrayList<>();
        S.add("f");
        S.add("f");
        S.add("r");
        S.add("l");
        S.add("f");
        ArrayList<MoveDirection> directions = new OptionsParser().parse(S);
        GrassField map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(10, map.getG().size());
    }
}
