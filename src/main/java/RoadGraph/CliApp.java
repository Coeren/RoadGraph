package RoadGraph;

import RoadGraph.Model.Graph;
import org.apache.commons.cli.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

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

//        Graph graph = new Graph();
//        graph.dummyInit();
//        dumpGraph(graph);

        try {
            Engine engine = new Engine();
            if (engine.checkPath(args[0], args[1]))
                System.out.println("Destination point reachable");
            else
                System.out.println("It is impossible to reach destination point using such directions");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private static void dumpGraph(Graph graph) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(Graph.class);
            Marshaller marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            FileOutputStream os = new FileOutputStream("sample.xml");
            marshaller.marshal(graph, os);
            os.close();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printUsage(Options opts){
        HelpFormatter hf = new HelpFormatter();
        hf.printHelp("RoadGraph <road graph file> <directions file>", "Checks if instructions let you reach destination point.", opts, "", true);
    }
}
