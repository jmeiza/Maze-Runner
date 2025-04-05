package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Action extends Command {
    
    public Action(Player player){
        super(player);
    }

    @Override
    public boolean execute(){
        this.player.makeMove();
        return true;
    }
}
