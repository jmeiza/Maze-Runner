package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Extract {
    
    private ArrayList<ArrayList<Cell>> maze;

    public Extract(){
        maze = new ArrayList<>();
    }

    public ArrayList<ArrayList<Cell>> extractMaze(String inputFile) throws IOException, FileNotFoundException{
     
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        line = reader.readLine();
        ArrayList<Cell> firstRow = new ArrayList<>();

        for (int idx = 0; idx < line.length(); idx++) {
            if (line.charAt(idx) == '#'){
                firstRow.add(Cell.WALL);
            }
            else {
                firstRow.add(Cell.PASS);
            }
            
        }

        maze.add(firstRow);         /*Adding the first row to the maze */
        int maxLength = line.length();          /*Getting the length of the first row since it will always be the longest row */

        while ((line = reader.readLine()) != null) {

            ArrayList<Cell> row = new ArrayList<>();
            
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#'){
                    row.add(Cell.WALL);
                }
                else {
                    row.add(Cell.PASS);
                }
            }

            /*Paading the row since the file contained lines that are shorter than the others */
            while (row.size() < maxLength) {
                row.add(Cell.PASS);
            }

            maze.add(row);
        }
        reader.close();
        return maze;
    }
}
