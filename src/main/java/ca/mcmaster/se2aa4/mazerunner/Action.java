package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Action extends Command {
    
    public Action(Player player){
        super(player);
    }

    @Override
    public void execute(){
        this.player.makeMove();
    }
}
