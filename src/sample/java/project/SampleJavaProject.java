package sample.java.project;

import java.util.Timer;
import java.util.TimerTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * The main class of the application. It contains the main() method,
 * the first method called.
 */
@NoArgsConstructor
@AllArgsConstructor
public class SampleJavaProject extends TimerTask {

    /** The delay between printed messages. */
    private static final long PRINT_DELAY = 1000L;

    /** The name to be printed in the output message. */
    @Getter @Setter @NonNull
    private String name = "world";

    /**
     * Print the "Hello, world!" string.
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
        SampleJavaProject sjp;
        if (line.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("SampleJavaProject [options]", options);
            System.exit(0);
        }
        if (line.hasOption("name")) {
            sjp = new SampleJavaProject(line.getOptionValue("name"));
        } else {
            sjp = new SampleJavaProject();
        }
        if (line.hasOption("loop")) {
            new Timer().schedule(sjp, 0L, PRINT_DELAY);
        } else {
            sjp.run();
        }
    }

    @Override
    public final void run() {
        System.out.printf("Hello, %s!\n", name);
    }
}
