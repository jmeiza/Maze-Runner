package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.ca.mcmaster.se2aa4.mazerunner.Cleaner;
import main.java.ca.mcmaster.se2aa4.mazerunner.Extract;
import main.java.ca.mcmaster.se2aa4.mazerunner.GameManager;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.PathCreator;
import main.java.ca.mcmaster.se2aa4.mazerunner.PathChecker;
import main.java.ca.mcmaster.se2aa4.mazerunner.Player;
import main.java.ca.mcmaster.se2aa4.mazerunner.Subject;
import main.java.ca.mcmaster.se2aa4.mazerunner.Observer;
import main.java.ca.mcmaster.se2aa4.mazerunner.Command;
import main.java.ca.mcmaster.se2aa4.mazerunner.ExecuteMove;
import main.java.ca.mcmaster.se2aa4.mazerunner.Check;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;

import org.apache.commons.cli.ParseException;


public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static CommandLine cmd = null;
    private static CommandLineParser parser = new DefaultParser();

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "reads a maze from a file");
        options.addOption("p", true, "checks if the given path is correct");

        Extract extract = new Extract();
        Player player;
        
        
        try{
            cmd = parser.parse(options,args);
        }
        catch(ParseException exp) {
            logger.error("An error occured in creating an instance of the command line!");
        }


        logger.info("** Starting Maze Runner");
        try {
            if (cmd.hasOption("i")){
                String inputFile = cmd.getOptionValue("i");

                logger.trace("**** Reading the maze from file " + inputFile);

                /*Creating an instance of the Maze class */
                Maze maze = new Maze(extract.extractMaze(inputFile));    

                player = new Player(maze.getEntry(), maze);         /*Creating the player object */
                
                /* Creating observers */
                PathCreator path = new PathCreator(player);
                GameManager gameManager = new GameManager(maze, player);
                
                /*Checks if the user gave instructions to be checked */
                if (cmd.hasOption("p")) {
                    logger.trace("**** Analyzing the given path");

                    Cleaner cleaner = new Cleaner();        /*Creating an instance of the Cleaner class to clean the string given by the user */

                    String inputPath = cmd.getOptionValue("p");

                    Command check = new Check(player, cleaner.clean(inputPath));    /*CReating the check command */

                    /*Checking if the path given by the user will work */
                    if (gameManager.executeCommand(check)) {
                        System.out.println("The path given will work!");
                    }
                    else {
                        System.out.println("The path given will not work!");
                    }
                }
                /*In the case that the user didn't give a path to be checked */
                else {
                    logger.trace("**** Computing path");
                    System.out.println();

                    Command command = new ExecuteMove(player);  /*Creating the execute move command */
                    
                    while (!gameManager.gameCondition()){
                        gameManager.executeCommand(command);
                    }
                    path.displayCanonicalPath();
                    path.displayFactorizedPath();
                    
                }
            }
        } 
        catch(Exception e) {
            logger.error("** " + e.getMessage());
        }
        

        logger.info("PATH NOT COMPUTED");
        System.out.println();
        logger.info("** End of MazeRunner");
    }
}
