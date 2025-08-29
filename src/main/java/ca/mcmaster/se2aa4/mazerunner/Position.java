package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.Objects;

public class Position {
    private int[] location;

    public Position(int row, int col) {
        this.location = new int[] {row,col};
    }

    public int getRow(){
        return this.location[0];
    }

    public int getCol(){
        return this.location[1];
    }

    public int[] getPosition() {
        int[] copy = {this.location[0], this.location[1]};
        return copy;
    }

    public void updatePosition(int rowDelta, int colDelta) {
        this.location[0] += rowDelta;
        this.location[1] += colDelta;
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;  // not even a Position
        }
        Position other = (Position) o;
        return this.location[0] == other.location[0] && this.location[1] == other.location[1];
    }

    @Override
    public int hashCode() {
        return Objects.hash(location[0], location[1]);
    }
    
    @Override
    public String toString() {
        return "(" + this.location[0] + ", " + this.location[1] + ")";
    }

}
