package sample.java.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 * Sample JUnit tests.
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
     * Tests the generated setter and getter methods.
     */
    @Test
    public final void testGetSet() {
        sjp.setName("foo");
        assertEquals("foo", sjp.getName());
    }

    /**
     * Tests that the null check in the setter.
     */
    @Test(expected=NullPointerException.class)
    public final void nullTest() {
        sjp.setName(null);
    }
}
