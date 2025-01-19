package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.text.html.Option;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class Main {

    private static final java.util.logging.Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Options options = new Option();
        options.addOption("i", true, "reads a maze from a file");
        CommandLineParser parser = new DefaultParser();
        
        try{
            CommandLine cmd = parser.parse(options,args);
        }
        catch(ParseException exp) {
            logger.error("An aerror occured in creating an instance of the command line!");
        }

        logger.info("** Starting Maze Runner");
        try {
            if (cmd.hasOption("i")){
                String inputFile = cmd.getOptionValue("i");

                logger.trace("**** Reading the maze from file " + inputFile);

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            System.out.print("PASS ");
                        }
                    }
                    System.out.print(System.lineSeparator());
                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.trace("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
