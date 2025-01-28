package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RightHand extends Algorithm {

    private char[] direction = {'N','E','S','W'};
    private StringBuilder instructions = new StringBuilder();

    
    public RightHand(Position start, Position end, ArrayList<ArrayList<Character>> maze) {
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
        return instructions;
    }

    private int facingNorth(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == ' ') {
            index = (index+1) % direction.length;
            instructions.append('R');
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == ' '){
            this.current.updateLocation(-1,0);
            instructions.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            instructions.append('L');
        }
        return index;
    }

    private int facingEast(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == ' ') {
            index = (index+1) % direction.length;
            instructions.append('R');               
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]+1) == ' '){
            this.current.updateLocation(0, 1);
            instructions.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            instructions.append('L');        }
        return index;
    }

    private int facingSouth(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]+1).get(this.current.getLocation()[1]) == ' '){
            this.current.updateLocation(1, 0);
            instructions.append('F');
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == ' ') {
            index = (index+ 1) % direction.length;
            instructions.append('R');         
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            instructions.append('L');
        }
        return index;
    }

    private int facingWest(int index) {
        if (this.mazeCopy.get(this.current.getLocation()[0]-1).get(this.current.getLocation()[1]) == ' ') {
            index = (index + 1) % direction.length;
            instructions.append('R');              
        }
        else if (this.mazeCopy.get(this.current.getLocation()[0]).get(this.current.getLocation()[1]-1) == ' '){
            this.current.updateLocation(0, -1);
            instructions.append('F');
        }
        else {
            index = (index - 1 + direction.length) % direction.length;
            instructions.append('L');
        }
        return index;
    }
}
