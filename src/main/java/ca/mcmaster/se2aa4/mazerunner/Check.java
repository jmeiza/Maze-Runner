package main.java.ca.mcmaster.se2aa4.mazerunner;


public class Check extends Command {
    StringBuilder path;

    public Check(Player player, StringBuilder sb){
        super(player);
        this.path = sb;
    }

    @Override
    public boolean execute(){
        return this.player.check(this.path);
    
    }
}
