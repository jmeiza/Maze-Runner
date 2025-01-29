package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class PathChecker {
    private ArrayList<ArrayList<Cell>> maze;
    private Direction dir;
    
    
    public PathChecker(ArrayList<ArrayList<Cell>> maze) {
        this.maze = maze;
        this.dir = Direction.EAST;
    }

    public boolean check(Position start, Position end, String str) {
        Position cur = start;
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            if (this.dir == Direction.NORTH) {
                cur = north(cur, sb.charAt(i));
            }
            else if (this.dir == Direction.EAST) {
                cur = east(cur, sb.charAt(i));
            }
            else if (this.dir == Direction.SOUTH) {
                cur = south(cur, sb.charAt(i));
            }
            else {
                cur = west(cur, sb.charAt(i));
            }

            /*Checks if we are still in bounds and then if we have hit a wall */
            if (cur.getLocation()[0] < this.maze.size() && cur.getLocation()[1] < this.maze.get(0).size()) {

                if (this.maze.get(cur.getLocation()[0]).get(cur.getLocation()[1]) == Cell.WALL) { 
                    return false;}
            }
            /*If we are out of bounds then we had to have hit the exit and some point because the only way out is the exit*/
            else {return true;}
        }
    
        /*After the given path has been exhausted, check if we are at the end of the maze */
        if (cur.equals(end)) {
            return true;
        }
        else {
            return false;
        }
    }

    private Position north(Position cur, char ch) {
        if (ch == 'F') {
            cur.updateLocation(-1,0);
        }
        else if (ch == 'R') {
            this.dir = Direction.EAST;
        }
        else {
            this.dir = Direction.WEST;
        }
        return cur;
    }

    private Position east(Position cur, char ch) {
        if (ch == 'F') {
            cur.updateLocation(0,1);
        }
        else if (ch == 'R') {
            this.dir = Direction.SOUTH;
        }
        else {
            this.dir = Direction.NORTH;
        }
        return cur;
    }

    private Position south(Position cur, char ch) {
        if (ch == 'F') {
            cur.updateLocation(1,0);
        }
        else if (ch == 'R') {
            this.dir = Direction.WEST;
        }
        else {
            this.dir = Direction.EAST;
        }
        return cur;
    }

    private Position west(Position cur, char ch) {
        if (ch == 'F') {
            cur.updateLocation(0,-1);
        }
        else if (ch == 'R') {
            this.dir = Direction.NORTH;
        }
        else {
            this.dir = Direction.SOUTH;
        }
        return cur;
    }

}
