package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Path {
    private StringBuilder instruction;

    public Path() {
        instruction = new StringBuilder();
    }

    public void generatePath() {
        instruction.append("FRFFLFFFRFLFRFRFF");
    }

    public void displayPath() {
        System.out.println(instruction);
    }
}
