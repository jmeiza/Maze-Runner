package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Maze {
    
    private ArrayList<ArrayList<Character>> maze;
    private Position entryLocation;
    private Position exitLocation;

    public Maze() {
        maze = new ArrayList<>();
    }
    
    public void addRow(ArrayList<Character> row) {
        maze.add(row);
    }

    public void displayMaze() {
        for (ArrayList<Character> row : maze) {
            for (Character cur : row) {
                System.out.print(cur);
            }
            System.out.println();
        }
    }

    public int[] getEntry() {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(0) == ' '){
                entryLocation =  new Position(i, 0);
            }
        }
        return entryLocation;
    }

    public int[] getExit() {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(maze.get(0).size()-1) == ' '){
                exitLocation = new Position(i, maze.get(0).size()-1);
            }
        }
        return exitLocation;
    }
    




}



