package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

abstract class Algorithm {
    protected List<List<Cell>> mazeCopy = new ArrayList<>();

    public Algorithm(List<List<Cell>> maze) {
        this.mazeCopy = maze;
    }
    public abstract Move nextMove(Position playerLocation, Direction playerDirection);
}
