package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    
    private ArrayList<ArrayList<Cell>> maze = new ArrayList<>();
    private Position entryLocation;
    private Position exitLocation;

    public Maze(ArrayList<ArrayList<Cell>> maze) {
        this.maze = maze;
    }
        
    public void displayMaze() {

        for (ArrayList<Cell> row : maze) {
            for (Cell cur : row) {
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
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(0) == Cell.PASS){
                entryLocation =  new Position(i, 0);
                break;
            }
        }
        return entryLocation;
    }

    public Position getExit() {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(maze.get(0).size()-1) == Cell.PASS){
                exitLocation = new Position(i, maze.get(0).size()-1);
                break;
            }
        }
        return exitLocation;
    }
    
    public ArrayList<ArrayList<Cell>> getMaze() {

        ArrayList<ArrayList<Cell>> copy = new ArrayList<>();

        for (ArrayList<Cell> row : this.maze) {
            copy.add(new ArrayList<>(row)); // Create a new list for each
        }
        return copy;
    }

}







