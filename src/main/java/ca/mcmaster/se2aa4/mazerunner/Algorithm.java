package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

abstract class Algorithm {
    protected Position end;
    protected Position current;
    protected ArrayList<ArrayList<Character>> mazeCopy = new ArrayList<>();

    public Algorithm(Position start, Position end, ArrayList<ArrayList<Character>> maze) {
        this.current = start;
        this.end = end;
        this.mazeCopy = maze;
    }
    public abstract StringBuilder generatePath();
}
