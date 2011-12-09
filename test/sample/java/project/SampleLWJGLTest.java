package sample.java.project;

import junit.framework.TestCase;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

/**
 * A sample JUnit test.
 *
 * This test exists as a placeholder for the test unit framework.
 */
public class SampleLWJGLTest extends TestCase {

    /**
     * JUnit set up method.
     */
    public final void setUp() {
        try {
            com.nullprogram.lwjgl.Lwjgl.setup();
        } catch (java.io.IOException e) {
            fail("Failed to load native libraries.");
        }
    }

    /**
     * Tests the add() method in the main class.
     */
    public final void testDisplay() {
        try {
            Display.create();
            Display.update();
            Display.destroy();
        } catch (LWJGLException e) {
            fail("" + e);
        }
    }
}
