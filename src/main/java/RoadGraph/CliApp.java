package RoadGraph;

import org.apache.commons.cli.*;

public class CliApp {
    public static void main(String[] args) {
        Options opts = new Options();
        opts.addOption("h", "help", false, "Print out help");
        CommandLine cmd;

        try {
            CommandLineParser cliParser = new DefaultParser();
            cmd = cliParser.parse(opts, args);
        } catch (ParseException e) {
            System.out.println("Invalid syntax");
            printUsage(opts);
            return;
        }

        if (cmd.hasOption("h")) {
            printUsage(opts);
            return;
        }

        if (args.length != 2) {
            System.out.println("Invalid syntax");
            printUsage(opts);
            return;
        }

//        RoadGraph graph = new RoadGraph(args[0]);
    }

    private static void printUsage(Options opts){
        HelpFormatter hf = new HelpFormatter();
        hf.printHelp("RoadGraph <road graph file> <instruction file>", "Checks if instructions let you reach destination point.", opts, "", true);
    }
}
