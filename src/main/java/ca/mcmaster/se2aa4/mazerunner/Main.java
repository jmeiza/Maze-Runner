package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.ca.mcmaster.se2aa4.mazerunner.Extract;
import main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import main.java.ca.mcmaster.se2aa4.mazerunner.Path;

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

        String inputFile;
        Options options = new Options();
        options.addOption("i", true, "reads a maze from a file");
        options.addOption("p", true, "checks if the given path is correct");

        Extract extract = new Extract();
        
        
        try{
            cmd = parser.parse(options,args);
        }
        catch(ParseException exp) {
            logger.error("An error occured in creating an instance of the command line!");
        }


        logger.info("** Starting Maze Runner");
        try {
            if (cmd.hasOption("i")){
                inputFile = cmd.getOptionValue("i");

                logger.trace("**** Reading the maze from file " + inputFile);

                Maze maze = new Maze(extract.extractMaze(inputFile));     /*Creating an instance of the Maze class */
                maze.displayMaze();

                Path path = new Path(maze);     /*Creating an instance of the Path Class */
                path.getPath();
                
                if (cmd.hasOption("p")) {
                    logger.trace("**** Analyzing the given path");
                    String inputPath = cmd.getOptionValue("p");
                    path.pathChecker(inputPath);
                }
                else {
                    logger.trace("**** Computing path");
                    System.out.println();
                    path.displayCanonicalPath();
                    path.displayFactorizedPath();
                    
                }
            }
        } 
        catch(Exception e) {
            logger.error("** " + e.getMessage());
        }
        

        //logger.info("PATH NOT COMPUTED");
        System.out.println();
        logger.info("** End of MazeRunner");
    }
}
