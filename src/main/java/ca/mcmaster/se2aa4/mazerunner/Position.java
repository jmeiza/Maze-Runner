package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int[] location;

    public Position(int row, int col) {
        this.location = new int[] {row,col};
    }

    public int[] getLocation() {
        int[] copy = {this.location[0], this.location[1]};
        return copy;
    }

    public void updateLocation(int rowDelta, int colDelta) {
        this.location[0] += rowDelta;
        this.location[1] += colDelta;
    }

    public boolean equals(Position location2) {
        if (this.location[0] == location2.getLocation()[0]) {
            if (this.location[1] == location2.getLocation()[1]) {
                return true;
            }
        }
        return false;
    }

}
