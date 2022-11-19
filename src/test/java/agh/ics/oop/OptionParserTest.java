import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
public class OptionParserTest {
    @Test
    public void parseTest(){
        List<String> S = new ArrayList<>();
        S.add("f");
        S.add("r");
        S.add("r");
        S.add("l");
        S.add("backward");
        ArrayList<MoveDirection> OKdirections = new ArrayList<>();
        OKdirections.add(MoveDirection.FORWARD);
        OKdirections.add(MoveDirection.RIGHT);
        OKdirections.add(MoveDirection.RIGHT);
        OKdirections.add(MoveDirection.LEFT);
        OKdirections.add(MoveDirection.BACKWARD);
        new OptionsParser();
        ArrayList<MoveDirection> directions = OptionsParser.parse(S);
        assertEquals(OKdirections, directions);
    }
    @Test
    public void parseTestThrow(){
        boolean thrown = false;
        try{
            List<String> S = new ArrayList<>();
            S.add("f");
            S.add("r");
            S.add("r");
            S.add("marmolada");
            S.add("backward");
            new OptionsParser();
            ArrayList<MoveDirection> directions = OptionsParser.parse(S);
        } catch (IllegalArgumentException ex) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
