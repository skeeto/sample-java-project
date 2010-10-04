package sample.java.project;

import junit.framework.TestCase;

/**
 * A sample JUnit test.
 *
 * This test exists as a placeholder for the test unit framework.
 */
public class SampleJavaProjectTest extends TestCase {

    /**
     * JUnit boilerplate.
     *
     * @param name the name string
     */
    public SampleJavaProjectTest(final String name) {
        super(name);
    }

    /**
     * Holds an instance of the class we are testing.
     */
    private SampleJavaProject sjp;

    /**
     * JUnit set up method.
     */
    public final void setUp() {
        sjp = new SampleJavaProject();
    }

    /**
     * Tests the add() method in the main class.
     */
    public final void testAdd() {
        assertEquals(sjp.add(3, 4), 7);
    }
}
