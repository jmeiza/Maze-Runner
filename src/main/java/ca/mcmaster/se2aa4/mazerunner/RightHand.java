package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RightHand extends Algorithm {

    private char[] direction = {'N','E','S','W'};
    private StringBuilder move = new StringBuilder();

    public RightHand(Position start, Position end, ArrayList<ArrayList<Cell>> maze) {
        super(start, end, maze);
    }

    @Override
    public StringBuilder generatePath() {
        int index = 1;

        while (this.current.equals(this.end) == false) {
            if (direction[index] == 'N') {
                index = facingNorth(index);
            }
            else if (direction[index] == 'E') {
                index = facingEast(index);
            }
            else if (direction[index] == 'S') {
                index = facingSouth(index);
            }
            else{
                index = facingWest(index);
            }
        }
        return move;
    }

    private int facingNorth(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == Cell.PASS && move.charAt(move.length()-1) != 'R') {
            index = (index+1) % direction.length;
            move.append('R');
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == Cell.PASS){
            this.current.updateLocation(-1,0);
            move.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            move.append('L');
        }
        return index;
    }

    private int facingEast(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == Cell.PASS  && move.charAt(move.length()-1) != 'R' ) {
            index = (index+1) % direction.length;
            move.append('R');               
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == Cell.PASS){
            this.current.updateLocation(0, 1);
            move.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            move.append('L');        
        }
        return index;
    }

    private int facingSouth(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == Cell.PASS && move.charAt(move.length()-1) != 'R') {
            index = (index+ 1) % direction.length;
            move.append('R');         
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == Cell.PASS){
            this.current.updateLocation(1, 0);
            move.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            move.append('L');
        }
        return index;
    }

    private int facingWest(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == Cell.PASS && move.charAt(move.length()-1) != 'R' ) {
            index = (index + 1) % direction.length;
            move.append('R');              
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == Cell.PASS){
            this.current.updateLocation(0, -1);
            move.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            move.append('L');
        }
        return index;
    }

}


