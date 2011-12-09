package sample.java.project;

import lombok.extern.java.Log;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * The main class.
 *
 * This is the main class of the application. It contains the main()
 * method, the first method called.
 */
@Log
public class SampleLwjglProject implements Runnable {

    /** The delay between frames. */
    private static final int FPS = 30;

    /** Width of the display. */
    private static final int WIDTH = 800;

    /** Height of the display. */
    private static final int HEIGHT = 600;

    /** The length of one second in milliseconds. */
    private static final double SECOND = 1000d;

    /** The size of the quad. */
    private static final float QUAD_SIZE = 200;

    /** Rate of red oscillation. */
    private static final float RED_RATE = 1f;

    /** Rate of green oscillation. */
    private static final float GREEN_RATE = 2.2f;

    /** Rate of blue oscillation. */
    private static final float BLUE_RATE = 0.125f;

    /** Rate of rotation oscillation. */
    private static final float ROT_RATE = 4f;

    /** Range of rotation oscillation. */
    private static final float ROT_RANGE = 12;

    /** Height division for quad. */
    private static final float HDIV = 4;

    /** Width division for quad. */
    private static final float WDIV = 2;

    /**
     * The main class.
     *
     * Print the "Hello, world!" string.
     *
     * @param args application input arguments
     */
    public static void main(final String[] args) {
        try {
            com.nullprogram.lwjgl.Lwjgl.setup();
        } catch (java.io.IOException e) {
            log.severe("could not prepare libraries: " + e);
            System.exit(0);
        }
        new SampleLwjglProject().run();
    }

    @Override
    public final void run() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
            init();
        } catch (LWJGLException e) {
            log.severe("could not prepare display: " + e);
            return;
        }

        while (!Display.isCloseRequested()) {
            repaint();
            Display.update();
            Display.sync(FPS);
        }
        Display.destroy();
    }

    /**
     * Initial display configuration.
     */
    private void init() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    /**
     * Draw the OpenGL display.
     */
    private void repaint() {
        double time = System.currentTimeMillis() / SECOND;

        /* Clear the screen and depth buffer */
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        /* set the color of the quad (R,G,B,A) */
        float red = (float) Math.abs(Math.sin(time * RED_RATE));
        float green = (float) Math.abs(Math.cos(time * GREEN_RATE));
        float blue = (float) Math.abs(Math.tan(time * BLUE_RATE));
        GL11.glColor3f(red, green, blue);

        /* draw quad */
        GL11.glPushMatrix();
        float r = (float) (Math.sin(time * ROT_RATE) * ROT_RANGE + ROT_RANGE);
        GL11.glRotatef(r, 0f, 0f, 1f);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(WIDTH / WDIV, HEIGHT / HDIV);
        GL11.glVertex2f(WIDTH / WDIV + QUAD_SIZE, HEIGHT / HDIV);
        GL11.glVertex2f(WIDTH / WDIV + QUAD_SIZE, HEIGHT / HDIV + QUAD_SIZE);
        GL11.glVertex2f(WIDTH / WDIV, HEIGHT / HDIV + QUAD_SIZE);
        GL11.glEnd();

        GL11.glPopMatrix();
    }
}
