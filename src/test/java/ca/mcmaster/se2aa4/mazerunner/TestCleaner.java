package test.java.ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.ca.mcmaster.se2aa4.mazerunner.Cleaner;

public class TestCleaner {

    private Cleaner cleaner;

    @BeforeEach
    public void setUp(){
        this.cleaner = new Cleaner();
    }

    /*Testing with a string that is already in canonical form but with spaces */
    @Test
    public void cleanMethodTest1(){
        StringBuilder expected = new StringBuilder("FFLRRLRLLF");
        String inpuString = "F FL R R LR LLF";
        StringBuilder actual = cleaner.clean(inpuString);

        assertEquals(expected.toString(),actual.toString());
    }

    /*Testing with a string that is in facotized form but with spaces */
    @Test
    public void cleanMethodTest2(){
        StringBuilder expected = new StringBuilder("RRRLLLFR");
        String inpuString = "3R 3L 1F 1R";
        StringBuilder actual = cleaner.clean(inpuString);

        assertEquals(expected.toString(),actual.toString());
    }

    /*Testing an empty string */
    @Test
    public void cleanMethodTest3(){
        StringBuilder expected = new StringBuilder("");
        String inpuString = " ";
        StringBuilder actual = cleaner.clean(inpuString);

        assertEquals(expected.toString(),actual.toString());
    }

    /*Testing with a string that is already in a cleaned form */
    @Test
    public void cleanMethodTest4(){
        StringBuilder expected = new StringBuilder("LFLFLFLF");
        String inpuString = "LFLFLFLF";
        StringBuilder actual = cleaner.clean(inpuString);

        assertEquals(expected.toString(),actual.toString());
    }

}