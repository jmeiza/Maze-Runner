package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BreadthFirstSearch extends Algorithm {
    private Queue<Position> queue = new LinkedList<>();
    private Set<Position> visited = new HashSet<>();
    private Map<Position, Position> parent = new HashMap<>();
    private List<Position> path = new ArrayList<>();
    private Position start;
    private Position exit;
    private int nextPositionIndex;

    public BreadthFirstSearch(List<List<Cell>> maze, Position start, Position exit) {
        super(maze);
        this.start = start;
        this.exit = exit;
        bfs();
        this.nextPositionIndex = 1;
    }

    @Override
    public Move nextMove(Position playerLocation, Direction playerDirection) {
        
        Position nextPosition = this.path.get(this.nextPositionIndex);
        Move next;

        if (playerDirection == Direction.NORTH) {
            next = facingNorth(nextPosition, playerLocation);
        }
        else if (playerDirection == Direction.EAST) {
            next = facingEast(nextPosition, playerLocation);
        }
        else if (playerDirection == Direction.WEST) {
            next = facingWest(nextPosition, playerLocation);
        }
        else {
            next = facingSouth(nextPosition, playerLocation);
        }
        
        if (next == Move.FORWARD) {
            this.nextPositionIndex += 1;
        }
        return next;
    }

    private void bfs() {
        this.queue.add(start);
        this.visited.add(start);
        this.parent.put(start, null);

        while (!this.queue.isEmpty()) {
            Position current = queue.poll();

            if (current.equals(this.exit)) {
                break;
            }

            for (Position neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    this.visited.add(neighbor);
                    this.parent.put(neighbor, current); // map child -> parent
                    this.queue.add(neighbor);
                }
            }
        }
        Position node = this.exit;

        while (node != null) {
            this.path.add(node);
            node = parent.get(node);
        }
        Collections.reverse(this.path);

    }

    private List<Position> getNeighbors(Position current){
        List<Position> neighbors = new ArrayList<>();
        int x_coord = current.getRow();
        int y_coord = current.getCol();

        int [][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] dir : directions) {
            int newX = x_coord + dir[0];
            int newY = y_coord + dir[1];

            if (newX >= 0 && newX < this.mazeCopy.size() && 
                newY >= 0 && newY < this.mazeCopy.get(0).size() && 
                this.mazeCopy.get(newX).get(newY) == Cell.PASS) {

                    neighbors.add(new Position(newX, newY));
                }
        }
        return neighbors;
    }
    
    private Move facingNorth(Position next, Position cur) {
        if (cur.getRow() - next.getRow() == -1) {
            return Move.RIGHT;
        }
        else if (cur.getRow() - next.getRow() == 1) {
            return Move.FORWARD;
        }
        else if (cur.getCol() - next.getCol() == 1) {
            return Move.LEFT;
        }
        else {
            return Move.RIGHT;
        }
    }

    private Move facingEast(Position next, Position cur) {
        // Going down to the next row
        if (cur.getRow() - next.getRow() == -1) {
            return Move.RIGHT;
        }
        // Going up to the previous row
        else if (cur.getRow() - next.getRow() == 1) {
            return Move.LEFT;
        }
        // Going one column to the left
        else if (cur.getCol() - next.getCol() == 1) {
            return Move.LEFT;
        }
        // Going one column to the right
        else {
            return Move.FORWARD;
        }
    }

    private Move facingSouth(Position next, Position cur) {
        // Going down to the next row
        if (cur.getRow() - next.getRow() == -1) {
            return Move.FORWARD;
        }
        // Going up to the previous row
        else if (cur.getRow() - next.getRow() == 1) {
            return Move.LEFT;
        }
        // Going one column to the left
        else if (cur.getCol() - next.getCol() == 1) {
            return Move.RIGHT;
        }
        // Going one column to the right
        else {
            return Move.LEFT;
        }
    }

    private Move facingWest(Position next, Position cur) {
        // Going down to the next row
        if (cur.getPosition()[0] - next.getPosition()[0] == -1) {
            return Move.LEFT;
        }
        // Going up to the previous row
        else if (cur.getRow() - next.getRow() == 1) {
            return Move.RIGHT;
        }
        // Going one column to the left
        else if (cur.getCol() - next.getCol() == 1) {
            return Move.FORWARD;
        }
        // Going one column to the right
        else {
            return Move.RIGHT;
        }
    }

}
