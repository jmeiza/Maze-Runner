package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int[] location;

    public Position(int row, int col) {
        this.location = new int[] {row,col};
    }

    public int[] getPosition() {
        int[] copy = {this.location[0], this.location[1]};
        return copy;
    }

    public void updatePosition(int rowDelta, int colDelta) {
        this.location[0] += rowDelta;
        this.location[1] += colDelta;
    }

    public boolean equals(Position location2) {
        /*Checks if two Position objects have the same coordinates */
        if (this.location[0] == location2.getPosition()[0]) {
            if (this.location[1] == location2.getPosition()[1]) {
                return true;
            }
        }
        return false;
    }

}
