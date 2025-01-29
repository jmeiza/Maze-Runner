package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RightHand extends Algorithm {

    private StringBuilder move = new StringBuilder();

    public RightHand(Position start, Position end, ArrayList<ArrayList<Cell>> maze) {
        super(start, end, maze);
    }

    @Override
    public StringBuilder generatePath() {
        Direction dir = Direction.EAST;

        while (this.current.equals(this.end) == false) {
            if (dir == Direction.NORTH) {
                dir = facingNorth(dir);
            }
            else if (dir == Direction.EAST) {
                dir = facingEast(dir);
            }
            else if (dir == Direction.SOUTH) {
                dir = facingSouth(dir);
            }
            else{
                dir = facingWest(dir);
            }
        }
        return move;
    }

    private Direction facingNorth(Direction dir) {
        if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == Cell.PASS && move.charAt(move.length()-1) != 'R') {
            dir = Direction.EAST;
            move.append('R');
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == Cell.PASS){
            this.current.updateLocation(-1,0);
            move.append('F');
        }
        else {
            dir = Direction.WEST;
            move.append('L');
        }
        return dir;
    }

    private int facingEast(Direction dir) {
        if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == Cell.PASS  && move.charAt(move.length()-1) != 'R' ) {
            dir = Direction.SOUTH;
            move.append('R');               
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == Cell.PASS){
            this.current.updateLocation(0, 1);
            move.append('F');
        }
        else {
            dir = Direction.NORTH;
            move.append('L');        
        }
        return dir;
    }

    private int facingSouth(Direction dir) {
        if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == Cell.PASS && move.charAt(move.length()-1) != 'R') {
            dir = Direction.WEST;
            move.append('R');         
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == Cell.PASS){
            this.current.updateLocation(1, 0);
            move.append('F');
        }
        else {
            dir = Direction.EAST;
            move.append('L');
        }
        return dir;
    }

    private int facingWest(Direction dir) {
        if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == Cell.PASS && move.charAt(move.length()-1) != 'R' ) {
            dir = Direction.NORTH;
            move.append('R');              
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == Cell.PASS){
            this.current.updateLocation(0, -1);
            move.append('F');
        }
        else {
            dir = Direction.SOUTH;
            move.append('L');
        }
        return dir;
    }

}


