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

    public Move nextMove(Position playerLocation, Direction playDirection) {
        Position nextPosition = this.path.get(this.nextPositionIndex);
        
        return Move.RIGHT;
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
        int x_coord = current.getPosition()[0];
        int y_coord = current.getPosition()[1];

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
    
}
