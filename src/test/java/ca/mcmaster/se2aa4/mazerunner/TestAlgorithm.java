package test.java.ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Direction;
import main.java.ca.mcmaster.se2aa4.mazerunner.Extract;
import main.java.ca.mcmaster.se2aa4.mazerunner.RightHand;
import main.java.ca.mcmaster.se2aa4.mazerunner.Move;

public class TestAlgorithm {

    private Extract extract = new Extract();
    private Maze maze;
    private RightHand solver;

    /*Testing the right hand algorithm on the straight maze */
    @Test
    public void Test1() throws FileNotFoundException, IOException{

        this.maze = new Maze(this.extract.extractMaze("./examples/straight.maz.txt"));
        solver = new RightHand(this.maze.getMaze());

        Move expected = Move.FORWARD;
        Move actual = solver.nextMove(this.maze.getEntry(),Direction.EAST);

        assertEquals(expected,actual);
    }

    /*Testing the right hand algorithm on the direct maze */
    @Test
    public void Test2() throws FileNotFoundException, IOException{

        this.maze = new Maze(this.extract.extractMaze("./examples/direct.maz.txt"));
        solver = new RightHand(this.maze.getMaze());

        Move expected = Move.FORWARD;
        Move actual = solver.nextMove(this.maze.getEntry(),Direction.EAST);

        assertEquals(expected,actual);
    }
}
