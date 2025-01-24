package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Path {
    private StringBuilder instruction;
    private Maze map;

    public Path(Maze map) {
        instruction = new StringBuilder();
        this.map = map;
    }

    public void generatePath() {
        instruction.append("FRFFLFFFRFLFRFRFF");
    }

    public void displayPath() {
        System.out.println("Path: " + instruction);
    }
}
