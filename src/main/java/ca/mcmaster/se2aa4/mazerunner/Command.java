package main.java.ca.mcmaster.se2aa4.mazerunner;


public abstract class Command {
    protected Player player;

    public Command(Player player){
        this.player = player;
    }

    public abstract boolean execute();
}
