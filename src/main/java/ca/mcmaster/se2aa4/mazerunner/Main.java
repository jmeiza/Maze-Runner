package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        Maze maze = new Maze();     /*Creating an instance of the Maze class */
        
        
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

                maze.createMaze(inputFile);
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        maze.displayMaze();

        logger.trace("**** Computing path");
        Path path = new Path(maze);     /*Creating an instance of the Path Class */
        path.generatePath();

        System.out.println();

        path.displayPath();

        //logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
