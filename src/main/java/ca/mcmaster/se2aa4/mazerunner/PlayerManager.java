package main.java.ca.mcmaster.se2aa4.mazerunner;


public class PlayerManager{
    private Player player;
    
    public PlayerManager(Player player){
       this.player = player;
    }

    public void update(Move nextMove, Direction dir){
        changeDirection(nextMove, dir);
        updateLocation(nextMove, dir);
        
    }

    private void updateLocation(Move nextMove, Direction dir){
        if (nextMove == Move.LEFT || nextMove == Move.RIGHT){
            this.player.getLocation().updatePosition(0, 0);
        }
        else {
            if (dir == Direction.NORTH){
                this.player.getLocation().updatePosition(-1, 0);
            }
            else if (dir == Direction.EAST){
                this.player.getLocation().updatePosition(0, 1);
            }
            else if (dir == Direction.SOUTH){
                this.player.getLocation().updatePosition(1, 0);
            }
            else {
                this.player.getLocation().updatePosition(0, -1);
            }
        }
    }

    private void changeDirection(Move nextMove, Direction dir){
        if (nextMove == Move.LEFT){
            this.player.setDirection(getLeft(dir));
        }
        else if (nextMove == Move.RIGHT){
            this.player.setDirection(getRight(dir));
        }
    }

    private Direction getLeft(Direction dir){
        if (dir == Direction.NORTH){
            return Direction.WEST;
        }
        else if (dir == Direction.SOUTH){
            return Direction.EAST;
        }
        else if (dir == Direction.WEST){
            return Direction.SOUTH;
        }
        else{
            return Direction.NORTH;
        }
    }

    private Direction getRight(Direction dir){
        if (dir == Direction.NORTH){
            return Direction.EAST;
        }
        else if (dir == Direction.SOUTH){
            return Direction.WEST;
        }
        else if (dir == Direction.WEST){
            return Direction.NORTH;
        }
        else{
            return Direction.SOUTH;
        }
    }
}
