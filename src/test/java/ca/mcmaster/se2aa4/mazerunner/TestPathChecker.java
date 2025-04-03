package test.java.ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.ca.mcmaster.se2aa4.mazerunner.PathChecker;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Extract;

public class TestPathChecker {
    
    private Extract extract = new Extract();
    private Maze maze;
    private PathChecker checker;
    private String inputFile = "./examples/straight.maz.txt";

    @BeforeEach
    public void setUp() throws FileNotFoundException, IOException{
        this.maze = new Maze(this.extract.extractMaze(inputFile));
        this.checker = new PathChecker(this.maze.getMaze());
    }

    /*Testing the path produced by the right hand rule algorithm */
    @Test
    public void checkMethodTest1(){
        StringBuilder testPath = new StringBuilder("FFFF");
        Boolean expected = true;
        Boolean actual = this.checker.check(this.maze.getEntry(), this.maze.getExit(), testPath);

        assertEquals(expected,actual);
    }

    /*Testing a path that shouldn't work */
    @Test
    public void checkMethodTest2(){
        StringBuilder testPath = new StringBuilder("FLFLF");
        Boolean expected = false;
        Boolean actual = this.checker.check(this.maze.getEntry(), this.maze.getExit(), testPath);

        assertEquals(expected,actual);
    }

    /*Testing a longer than needed path that would actually work */
    @Test
    public void checkMethodTest3(){
        StringBuilder testPath = new StringBuilder("FLLLLFFRRRRF");
        Boolean expected = true;
        Boolean actual = this.checker.check(this.maze.getEntry(), this.maze.getExit(), testPath);

        assertEquals(expected,actual);
    }

    /*Testing an empty path */
    @Test
    public void checkMethodTest4(){
        StringBuilder testPath = new StringBuilder(" ");
        Boolean expected = false;
        Boolean actual = this.checker.check(this.maze.getEntry(), this.maze.getExit(), testPath);

        assertEquals(expected,actual);
    }

    /*FACTORIZED PATHS AND PATHS WITH NUMBERS AREN'T TESTED BECAUSE THE METHOD USED TO CLEAN SUCH KIND OF PATHS IS ALWAYS
     * CALLED ON THE GIVEN PATH BEFORE IT IS PASSED INTO THIS FUNCTION. THE CLEAN PATH IS TESTED IN ANOTHER FILE
     */
}
