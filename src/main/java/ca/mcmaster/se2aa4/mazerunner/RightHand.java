package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class RightHand extends Algorithm {

    private Move prevMove;

    public RightHand(List<List<Cell>> maze) {
        super(maze);
    }

    @Override
    public Move nextMove(Position playerLocation, Direction playerDirection){
        if (playerDirection == Direction.NORTH) {           /*Currently facing north */
            this.prevMove = facingNorth(playerLocation);         
        }
        else if (playerDirection == Direction.EAST) {       /*Currently facing east */
            this.prevMove = facingEast(playerLocation);
        }
        else if (playerDirection == Direction.SOUTH) {      /*Currently facing south */
            this.prevMove = facingSouth(playerLocation);
        }
        else{
            this.prevMove = facingWest(playerLocation);              /*Currently facing west */
        }
        return this.prevMove;
    }

    private Move facingNorth(Position cur) {
        /*Checks if there is space to the right and if the last move made was a right turn*/
        if (this.mazeCopy.get(cur.getPosition()[0]).get(cur.getPosition()[1]+1) == Cell.PASS && 
            prevMove != Move.RIGHT) {

            return Move.RIGHT;  /*Turns right*/
        }
        /*Checks if there is space moving forward*/
        else if (this.mazeCopy.get(cur.getPosition()[0]-1).get(cur.getPosition()[1]) == Cell.PASS){
            return Move.FORWARD;
        }
        else {
           /*Turns left */
            return Move.LEFT;
        }
    }

    private Move facingEast(Position cur) {
        /*Checks if there is space to the right and if the last move made was a right turn*/
        if (this.mazeCopy.get(cur.getPosition()[0]+1).get(cur.getPosition()[1]) == Cell.PASS  && 
            prevMove != Move.RIGHT ) {
            
            /*Turns right */
            return Move.RIGHT;               
        }
        /*Checks if there is space moving forward */
        else if (this.mazeCopy.get(cur.getPosition()[0]).get(cur.getPosition()[1]+1) == Cell.PASS){
            return Move.FORWARD;
        }
        else {
            /*Turns left */
            return Move.LEFT;        
        }
    }

    private Move facingSouth(Position cur) {
        /*Checks if a right turn is possible */
        if (this.mazeCopy.get(cur.getPosition()[0]).get(cur.getPosition()[1]-1) == Cell.PASS && 
            prevMove != Move.RIGHT) {

            /*Turns right */
            return Move.RIGHT;        
        }
        /*Checks if moving forward is possible*/
        else if (this.mazeCopy.get(cur.getPosition()[0]+1).get(cur.getPosition()[1]) == Cell.PASS){
            return Move.FORWARD;
        }
        else {
            /*Turns left */
            return Move.LEFT;
        }
    }

    private Move facingWest(Position cur) {
        /*Checking for a right turn */
        if (this.mazeCopy.get(cur.getPosition()[0]-1).get(cur.getPosition()[1]) == Cell.PASS && 
            prevMove != Move.RIGHT ) {

            /*Turns right */
            return Move.RIGHT;              
        }
        /*Checks if moving forward is possible */
        else if (this.mazeCopy.get(cur.getPosition()[0]).get(cur.getPosition()[1]-1) == Cell.PASS){
            return Move.FORWARD;
        }
        else {
            /*Turns left */
            return Move.LEFT;
        }
    }

}


