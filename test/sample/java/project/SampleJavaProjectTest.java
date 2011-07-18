package sample.java.project;

import junit.framework.TestCase;

/**
 * A sample JUnit test.
 *
 * This test exists as a placeholder for the test unit framework.
 */
public class SampleJavaProjectTest extends TestCase {

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
        assertEquals(sjp.add(5, -5), 0);
        assertEquals(sjp.add(-3, 4), 1);
    }
}
