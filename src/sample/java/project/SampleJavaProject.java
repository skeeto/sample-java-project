package sample.java.project;

/**
 * The main class.
 *
 * This is the main class of the application. It contains the main()
 * method, the first method called.
 */
public class SampleJavaProject {

    /**
     * The main class.
     *
     * Print the "Hello, world!" string.
     *
     * @param args application input arguments
     */
    public static void main(final String[] args) {
        System.out.println("Hello, world!");
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
