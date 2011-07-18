package sample.java.project;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;

/**
 * The main class.
 *
 * This is the main class of the application. It contains the main()
 * method, the first method called.
 */
public class SampleJavaProject {

    /** The name to printed in the output message. */
    private static String name = "world";

    /**
     * The main class.
     *
     * Print the "Hello, world!" string.
     *
     * @param args application input arguments
     */
    public static void main(final String[] args) {
        /* Set up the command line arguments. */
        Options options = new Options();
        options.addOption(new Option("name", true, "set the user's name"));
        options.addOption(new Option("help", "print this help message"));
        CommandLine line = null;
        try {
            line = new GnuParser().parse(options, args);
        } catch (org.apache.commons.cli.ParseException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        /* Handle each argument. */
        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("SampleJavaProject [options]", options);
            System.exit(0);
        }
        if (line.hasOption("name")) {
            name = line.getOptionValue("name");
        }

        /* Print out our message. */
        System.out.printf("Hello, %s!\n", name);
    }

    /**
     * Add two integers together.
     *
     * This is a dumb method that is here for the purposed of unit
     * testing.
     *
     * @param  a first number
     * @param  b second number
     * @return sum of the numbers
     */
    public final int add(final int a, final int b) {
        return a + b;
    }
}
