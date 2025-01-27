package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    
    private ArrayList<ArrayList<Character>> maze;
    private Position entryLocation;
    private Position exitLocation;

    public Maze() {
        maze = new ArrayList<>();
    }
    
    public void createMaze(String inputFile) throws IOException, FileNotFoundException{
     
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        /*Replicating the maze in the maze object */
        while ((line = reader.readLine()) != null) {

            ArrayList<Character> row = new ArrayList<>();

            for (int idx = 0; idx < line.length(); idx++) {
                row.add(line.charAt(idx));
            }
            maze.add(row);
        }
        reader.close();
    
    }
        
    public void displayMaze() {
        for (ArrayList<Character> row : maze) {
            for (Character cur : row) {
                System.out.print(cur);
            }
            System.out.println();
        }
    }

    public Position getEntry() {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(0) == ' '){
                entryLocation =  new Position(i, 0);
                break;
            }
        }
        return entryLocation;
    }

    public Position getExit() {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).get(maze.get(0).size()-1) == ' '){
                exitLocation = new Position(i, maze.get(0).size()-1);
                break;
            }
        }
        return exitLocation;
    }
    
    public ArrayList<ArrayList<Character>> getMaze() {

        ArrayList<ArrayList<Character>> copy = new ArrayList<>();

        for (ArrayList<Character> row : this.maze) {
            copy.add(new ArrayList<>(row)); // Create a new list for each
        }
        return copy;

    }

}







