package main.java.ca.mcmaster.se2aa4.mazerunner;

public class GameManager extends Observer {
    private Maze maze;
    private Position playerPosition;
    private boolean isGameOver = false;

    public GameManager(Maze maze, Subject subject){
        this.maze = maze;
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        playerPosition = this.subject.getLocation();

        this.isGameOver = playerPosition.equals(this.maze.getExit());
    }

    public boolean gameCondition(){
        return this.isGameOver;
    }


}
