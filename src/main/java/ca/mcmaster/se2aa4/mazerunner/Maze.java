package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    
    private List<List<Cell>> maze;
    private Position entryLocation;
    private Position exitLocation;

    public Maze(List<List<Cell>> maze) {
        this.maze = maze;
    }
        
    public void displayMaze() {

        for (List<Cell> row : maze) {      /*Looping through row by row */
            for (Cell cur : row) {              /*Looping through every cell in a row */
                if (cur == Cell.WALL) {
                    System.out.print('#');
                }
                else {
                    System.out.print(' ');
                }   
            }
            System.out.println();
        }
    }

    public Position getEntry() {
        /*Looping row by row through the first column until a PASS is found */
        for (int i = 0; i < maze.size(); i++) {         
            if (maze.get(i).get(0) == Cell.PASS){
                entryLocation =  new Position(i, 0);
                break;
            }
        }
        return entryLocation;   
    }

    public Position getExit() {
        /*Looping row by row through the last column until a PASS is found */
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(maze.get(0).size()-1) == Cell.PASS){
                exitLocation = new Position(i, maze.get(0).size()-1);
                break;
            }
        }
        return exitLocation;    
    }
    
    public List<List<Cell>> getMaze() {

        List<List<Cell>> copy = new ArrayList<>();
        
        /*creating a deep copy of the maze */
        for (List<Cell> row : this.maze) {
            copy.add(new ArrayList<>(row)); // Create a new list for each
        }
        return copy;
    }

}







