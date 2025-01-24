package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Path {
    private StringBuilder instruction;

    public Path() {
        instruction = new StringBuilder();
    }

    public boolean generatePath() {
        instruction.append("FRFFLFFFRFLFRFRFF");
        return true;
    }

    public void displayPath() {
        System.out.println(instruction);
    }
}
