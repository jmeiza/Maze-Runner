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

    public boolean executeCommand(Command command){
        return command.execute();
    }

    @Override
    public void update() {
        playerPosition = this.subject.getLocation();        /*The subject here is the player */

        this.isGameOver = playerPosition.equals(this.maze.getExit());   /*Checking if the player is currently at the exit */
    }

    public boolean gameCondition(){
        return this.isGameOver;
    }


}
