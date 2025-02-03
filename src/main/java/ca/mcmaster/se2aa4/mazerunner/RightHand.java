package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class RightHand extends Algorithm {

    private StringBuilder move = new StringBuilder();

    public RightHand(Position start, Position end, List<List<Cell>> maze) {
        super(start, end, maze);
    }

    @Override
    public StringBuilder generatePath() {
        Direction dir = Direction.EAST;

        while (this.current.equals(this.end) == false) {        /*Checks if the current position is equal to the exit spot of the maze */
            
            if (dir == Direction.NORTH) {           /*Currently facing north */
                dir = facingNorth(dir);         
            }
            else if (dir == Direction.EAST) {       /*Currently facing east */
                dir = facingEast(dir);
            }
            else if (dir == Direction.SOUTH) {      /*Currently facing south */
                dir = facingSouth(dir);
            }
            else{
                dir = facingWest(dir);              /*Currently facing west */
            }
        }
        return move;
    }

    private Direction facingNorth(Direction dir) {
        /*Checks if there is space to the right and if the last move made was a right turn*/
        if (this.mazeCopy.get(this.current.getPosition()[0]).get(this.current.getPosition()[1]+1) == Cell.PASS && 
            move.charAt(move.length()-1) != 'R') {

            dir = Direction.EAST;       /*Turns right*/
            move.append('R');
        }
        /*Checks if there is space moving forward*/
        else if (this.mazeCopy.get(this.current.getPosition()[0]-1).get(this.current.getPosition()[1]) == Cell.PASS){
            this.current.updatePosition(-1,0);  /*Updates the current position to move forward */
            move.append('F');
        }
        else {
            dir = Direction.WEST;       /*Turns left */
            move.append('L');
        }
        return dir;
    }

    private Direction facingEast(Direction dir) {
        /*Checks if there is space to the right and if the last move made was a right turn*/
        if (this.mazeCopy.get(this.current.getPosition()[0]+1).get(this.current.getPosition()[1]) == Cell.PASS  && 
            move.charAt(move.length()-1) != 'R' ) {
            
            dir = Direction.SOUTH;  /*Turns right */
            move.append('R');               
        }
        /*Checks if there is space moving forward */
        else if (this.mazeCopy.get(this.current.getPosition()[0]).get(this.current.getPosition()[1]+1) == Cell.PASS){
            this.current.updatePosition(0, 1);  /*Updates the current position to move forward */
            move.append('F');
        }
        else {
            dir = Direction.NORTH;  /*Turns left */
            move.append('L');        
        }
        return dir;
    }

    private Direction facingSouth(Direction dir) {
        /*Checks if a right turn is possible */
        if (this.mazeCopy.get(this.current.getPosition()[0]).get(this.current.getPosition()[1]-1) == Cell.PASS && 
            move.charAt(move.length()-1) != 'R') {

            dir = Direction.WEST;   /*Turns right */
            move.append('R');         
        }
        /*Checks if moving forward is possible*/
        else if (this.mazeCopy.get(this.current.getPosition()[0]+1).get(this.current.getPosition()[1]) == Cell.PASS){
            this.current.updatePosition(1, 0);  /*Updates current position to move forward */
            move.append('F');
        }
        else {
            dir = Direction.EAST;   /*Turns left */
            move.append('L');
        }
        return dir;
    }

    private Direction facingWest(Direction dir) {
        /*Checking for a right turn */
        if (this.mazeCopy.get(this.current.getPosition()[0]-1).get(this.current.getPosition()[1]) == Cell.PASS && 
            move.charAt(move.length()-1) != 'R' ) {

            dir = Direction.NORTH;  /*Turns right */
            move.append('R');              
        }
        /*Checks if moving forward is possible */
        else if (this.mazeCopy.get(this.current.getPosition()[0]).get(this.current.getPosition()[1]-1) == Cell.PASS){
            this.current.updatePosition(0, -1);     /*Moves forward */
            move.append('F');
        }
        else {
            dir = Direction.SOUTH;      /*Turns left */
            move.append('L');
        }
        return dir;
    }

}


