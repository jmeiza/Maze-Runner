package main.java.ca.mcmaster.se2aa4.mazerunner;


public class Player extends Subject {
    private Algorithm strategy;

    private Position curLocation;
    
    private Direction curDir;

    private Maze maze;

    private Move nextMove;

    private PlayerManager manager;

    public Player(Position startLocation, Maze maze){
        this.curLocation = startLocation;
        this.maze = maze;
        strategy = new RightHand(this.maze.getMaze());
        this.curDir = Direction.EAST;
        manager = new PlayerManager(this);
    }

    @Override
    public Position getLocation(){
        return this.curLocation;
    }

    @Override
    public Move getMove(){
        return this.nextMove;
    }

    public Direction getDirection(){
        return this.curDir;
    }

    public void setDirection(Direction newDirection){
        this.curDir = newDirection;
    }


    public void makeMove(){
        this.nextMove = strategy.nextMove(this.curLocation, this.curDir);
        manager.update(nextMove, curDir);
        this.notifyAllObservers();
    }
    




    

}
