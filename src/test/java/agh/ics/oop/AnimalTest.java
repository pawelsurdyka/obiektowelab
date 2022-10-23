package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class AnimalTest {

    Animal surykatka = new Animal();
    // (2,2) NORTH
    private MoveDirection direction1 = MoveDirection.FORWARD;
    private MoveDirection direction2 = MoveDirection.BACKWARD;
    private MoveDirection direction3 = MoveDirection.LEFT;
    private MoveDirection direction4 = MoveDirection.RIGHT;

    @Test
    public void orientationTest(){
        assertEquals(surykatka.move(direction1),"(2,3) NORTH");
        assertEquals(surykatka.move(direction2),"(2,2) NORTH");
        assertEquals(surykatka.move(direction3),"(2,2) WEST");
        assertEquals(surykatka.move(direction4),"(2,2) NORTH");
        assertEquals(surykatka.move(direction3),"(2,2) WEST");
        assertEquals(surykatka.move(direction3),"(2,2) SOUTH");
        assertEquals(surykatka.move(direction3),"(2,2) EAST");
        assertEquals(surykatka.move(direction3),"(2,2) NORTH");
    }

    @Test
    public void moveTest(){
        assertEquals(surykatka.move(direction1),"(2,3) NORTH");
        assertEquals(surykatka.move(direction2),"(2,2) NORTH");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(1,2) WEST");
        assertEquals(surykatka.move(direction2),"(2,2) WEST");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(2,1) SOUTH");
        assertEquals(surykatka.move(direction2),"(2,2) SOUTH");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(3,2) EAST");
        assertEquals(surykatka.move(direction2),"(2,2) EAST");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(2,3) NORTH");
        assertEquals(surykatka.move(direction2),"(2,2) NORTH");
    }

    @Test
    public void inmapTest(){
        assertEquals(surykatka.move(direction1),"(2,3) NORTH");
        assertEquals(surykatka.move(direction1),"(2,4) NORTH");
        assertEquals(surykatka.move(direction1),"(2,4) NORTH");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(1,4) WEST");
        assertEquals(surykatka.move(direction1),"(0,4) WEST");
        assertEquals(surykatka.move(direction1),"(0,4) WEST");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(0,3) SOUTH");
        assertEquals(surykatka.move(direction1),"(0,2) SOUTH");
        assertEquals(surykatka.move(direction1),"(0,1) SOUTH");
        assertEquals(surykatka.move(direction1),"(0,0) SOUTH");
        assertEquals(surykatka.move(direction1),"(0,0) SOUTH");
        surykatka.move(direction3);
        assertEquals(surykatka.move(direction1),"(1,0) EAST");
        assertEquals(surykatka.move(direction1),"(2,0) EAST");
        assertEquals(surykatka.move(direction1),"(3,0) EAST");
        assertEquals(surykatka.move(direction1),"(4,0) EAST");
        assertEquals(surykatka.move(direction1),"(4,0) EAST");
    }

    private String[] args1 = {"f","b","r","l","forward","backward","right","left"};
    private MoveDirection[] res1 = {MoveDirection.FORWARD,MoveDirection.BACKWARD,
            MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.BACKWARD,
            MoveDirection.RIGHT,MoveDirection.LEFT};

    @Test
    public void parserTest1(){
        assertEquals(OptionsParser.parse(args1)[0],res1[0]);
        assertEquals(OptionsParser.parse(args1)[1],res1[1]);
        assertEquals(OptionsParser.parse(args1)[2],res1[2]);
        assertEquals(OptionsParser.parse(args1)[3],res1[3]);
        assertEquals(OptionsParser.parse(args1)[4],res1[4]);
        assertEquals(OptionsParser.parse(args1)[5],res1[5]);
        assertEquals(OptionsParser.parse(args1)[6],res1[6]);
        assertEquals(OptionsParser.parse(args1)[7],res1[7]);
    }

    private String[] args2 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","t","w"};
    private MoveDirection[] res2= {MoveDirection.BACKWARD,MoveDirection.FORWARD,
            MoveDirection.LEFT,MoveDirection.RIGHT};
    @Test
    public void parserTest2(){
        assertEquals(OptionsParser.parse(args1)[0],res1[0]);
        assertEquals(OptionsParser.parse(args1)[1],res1[1]);
        assertEquals(OptionsParser.parse(args1)[2],res1[2]);
        assertEquals(OptionsParser.parse(args1)[3],res1[3]);
        assertEquals(OptionsParser.parse(args1)[4],res1[4]);
    }
}
