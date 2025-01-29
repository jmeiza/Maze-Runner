package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

abstract class Algorithm {
    protected Position end;
    protected Position current;
    protected ArrayList<ArrayList<Cell>> mazeCopy = new ArrayList<>();

    public Algorithm(Position start, Position end, ArrayList<ArrayList<Cell>> maze) {
        this.current = start;
        this.end = end;
        this.mazeCopy = maze;
    }
    public abstract StringBuilder generatePath();
}
