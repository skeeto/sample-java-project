package sample.java.project;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * The main class.
 *
 * This is the main class of the application. It contains the main()
 * method, the first method called.
 */
public class SampleJavaProject extends TimerTask {

    /** The delay between printed messages. */
    private static final long PRINT_DELAY = 1000L;

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
        options.addOption(new Option("loop", "print endlessly, hotswap demo"));
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
        if (line.hasOption("loop")) {
            new Timer().schedule(new SampleJavaProject(), 0L, PRINT_DELAY);
        } else {
            new SampleJavaProject().run();
        }
    }

    @Override
    public final void run() {
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
