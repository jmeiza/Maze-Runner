package main.java.ca.mcmaster.se2aa4.mazerunner;

public class ExecuteMove extends Command {
    
    public ExecuteMove(Player player){
        super(player);
    }

    @Override
    public boolean execute(){
        this.player.makeMove();
        return true;
    }
}
