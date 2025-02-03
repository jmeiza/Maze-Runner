package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

abstract class Algorithm {
    protected Position end;
    protected Position current;
    protected List<List<Cell>> mazeCopy = new ArrayList<>();

    public Algorithm(Position start, Position end, List<List<Cell>> maze) {
        this.current = start;
        this.end = end;
        this.mazeCopy = maze;
    }
    public abstract StringBuilder generatePath();
}
