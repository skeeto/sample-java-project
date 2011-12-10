package sample.java.project;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

/**
 * The main class.
 *
 * This is the main class of the application. It contains the main()
 * method, the first method called.
 */
public class SampleLwjglProject implements Runnable {

    /** The delay between frames. */
    private static final int FPS = 60;

    /** Width of the display. */
    private static final int WIDTH = 600;

    /** Height of the display. */
    private static final int HEIGHT = 600;

    /** The length of one second in milliseconds. */
    private static final double SECOND = 1000d;

    /** Rate of rotation. */
    private static final float ROTS_RATE = 100f;

    /** Rate of rotation oscillation. */
    private static final float ROTR_RATE = 4f;

    /** Range of rotation oscillation. */
    private static final float ROT_RANGE = 36;

    /** Red diffuse light. */
    private static final float[] DIFFUSE = {1f, 0f, 0f, 1f};

    /** Infinite light location. */
    private static final float[] POSITION = {1f, 1f, 1f, 0f};

    /** Normals for the 6 faces of a cube. */
    private static final float[][] NORMALS = {
        {-1f, 0f, 0f}, {0f, 1f, 0f}, {1f, 0f, 0f},
        {0f, -1f, 0f}, {0f, 0f, 1f}, {0f, 0f, -1f}
    };

    /** Vertex indices for the 6 faces of a cube. */
    private static final int[][] FACES = {
        {0, 1, 2, 3}, {3, 2, 6, 7}, {7, 6, 5, 4},
        {4, 5, 1, 0}, {5, 6, 2, 1}, {7, 4, 0, 3}
    };

    /** Will be filled in with X, Y, Z vertexes. */
    private static final float[][] V = new float[8][3];

    /** Colors of the sides of the cube. */
    private static final float[][] COLORS = {
        {1f, 0f, 0f}, {0f, 1f, 0f}, {0f, 0f, 1f},
        {1f, 1f, 0f}, {0f, 1f, 1f}, {1f, 0f, 1f}
    };

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
            System.out.println("error: could not prepare libraries: " + e);
            System.exit(0);
        }
        new SampleLwjglProject().run();
    }

    @Override
    public final void run() {
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("LWJGL Cube Demo");
            Display.create();
            init();
        } catch (LWJGLException e) {
            System.out.println("error: could not prepare display: " + e);
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
     * Wrap a float array with a direct FloatBuffer.
     * @param in  the float array to be wrapped
     * @return a direct FloatBuffer
     */
    private FloatBuffer wrap(final float[] in) {
        FloatBuffer buffer;
        buffer = BufferUtils.createFloatBuffer(in.length * 4);
        return buffer.put(in);
    }

    /**
     * Initial display configuration.
     */
    private void init() {
        /* Setup cube vertex data. */
        V[0][0] = V[1][0] = V[2][0] = V[3][0] = -1;
        V[4][0] = V[5][0] = V[6][0] = V[7][0] = 1;
        V[0][1] = V[1][1] = V[4][1] = V[5][1] = -1;
        V[2][1] = V[3][1] = V[6][1] = V[7][1] = 1;
        V[0][2] = V[3][2] = V[4][2] = V[7][2] = 1;
        V[1][2] = V[2][2] = V[5][2] = V[6][2] = -1;

        /* Enable a single OpenGL light. */
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, wrap(DIFFUSE));
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, wrap(POSITION));
        GL11.glEnable(GL11.GL_LIGHT0);
        //GL11.glEnable(GL11.GL_LIGHTING);

        /* Use depth buffering for hidden surface elimination. */
        GL11.glEnable(GL11.GL_DEPTH_TEST);

        /* Setup the view of the cube. */
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        Project.gluPerspective(40f, 1f, 1f, 10f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        Project.gluLookAt(0f, 0f, 5f,
                          0f, 0f, 0f,
                          0f, 1f, 0f);

        /* Adjust cube position to be asthetic angle. */
        GL11.glTranslatef(0f, 0f, -1f);
        GL11.glRotatef(60f, 1f, 0f, 0f);
        GL11.glRotatef(-20f, 0f, 0f, 1f);
    }

    /**
     * Draw the OpenGL display.
     */
    private void repaint() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        double time = System.currentTimeMillis() / SECOND;
        GL11.glPushMatrix();
        float r = (float) (Math.sin(time * ROTR_RATE) * ROT_RANGE + ROT_RANGE);
        GL11.glRotatef(r, 0f, 0f, 1f);
        float s = (float) (time * ROTS_RATE % 360);
        GL11.glRotatef(s, 1f, 0f, 0f);

        for (int i = 0; i < 6; i++) {
            GL11.glBegin(GL11.GL_QUADS);
            GL11.glColor3f(COLORS[i][0], COLORS[i][1], COLORS[i][2]);
            GL11.glNormal3f(NORMALS[i][0], NORMALS[i][1], NORMALS[i][2]);
            GL11.glVertex3f(V[FACES[i][0]][0],
                            V[FACES[i][0]][1],
                            V[FACES[i][0]][2]);
            GL11.glVertex3f(V[FACES[i][1]][0],
                            V[FACES[i][1]][1],
                            V[FACES[i][1]][2]);
            GL11.glVertex3f(V[FACES[i][2]][0],
                            V[FACES[i][2]][1],
                            V[FACES[i][2]][2]);
            GL11.glVertex3f(V[FACES[i][3]][0],
                            V[FACES[i][3]][1],
                            V[FACES[i][3]][2]);
            GL11.glEnd();
        }

        GL11.glPopMatrix();
    }
}
