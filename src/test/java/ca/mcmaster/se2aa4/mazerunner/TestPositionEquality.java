package test.java.ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.ca.mcmaster.se2aa4.mazerunner.Position;

public class TestPositionEquality {
    private Position position;

    @BeforeEach
    public void setUp(){
        this.position = new Position(3,4);
    }

    /*Testing the method used to get the coordinates */
    @Test
    public void getPositionTest(){
        int[] expected = {3,4};
        int[] actual = this.position.getPosition();

        assertArrayEquals(expected,actual);
    }
    
    /*Testing the updatePosition method. Note: This method is used as a part of a larger alogirthm so it's never called
     * with just any number that could possibly break the program e.g the max value for an integer.
     */
    @Test
    public void updatePositionTest(){
        int[] expected = {5,10};
        this.position.updatePosition(2,6);
        int[] actual = this.position.getPosition();

        assertArrayEquals(expected,actual);
    }

    /*Testing the method used to check if two psoition objects are equal */
    @Test
    public void equalsTest(){
        Boolean expected = true;
        Position testPosition = new Position(3,4);
        Boolean actual = this.position.equals(testPosition);

        assertEquals(expected,actual);
    }

    @Test
    public void equalsTest2(){
        Boolean expected = false;
        Position testPosition = new Position(10,11);
        Boolean actual = this.position.equals(testPosition);

        assertEquals(expected,actual);
    }
}
