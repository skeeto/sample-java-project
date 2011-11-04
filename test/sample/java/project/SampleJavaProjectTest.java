package sample.java.project;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * A sample JUnit test.
 *
 * This test exists as a placeholder for the test unit framework.
 */
public class SampleJavaProjectTest {

    /**
     * Holds an instance of the class we are testing.
     */
    private SampleJavaProject sjp;

    /**
     * JUnit set up method.
     */
    @Before
    public final void setUp() {
        sjp = new SampleJavaProject();
    }

    /**
     * Tests the add() method in the main class.
     */
    @Test
    public final void testAdd() {
        assertEquals(sjp.add(3, 4), 7);
        assertEquals(sjp.add(5, -5), 0);
        assertEquals(sjp.add(-3, 4), 1);
    }
}
