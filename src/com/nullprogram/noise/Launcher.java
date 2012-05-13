package com.nullprogram.noise;

import com.nullprogram.lwjgl.GlFloatBuffer;
import com.nullprogram.lwjgl.Lwjgl;
import com.nullprogram.lwjgl.Program;
import com.nullprogram.lwjgl.Shader;
import com.nullprogram.lwjgl.VertexShader;
import com.nullprogram.lwjgl.FragmentShader;
import java.net.URL;
import java.nio.FloatBuffer;
import lombok.SneakyThrows;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

public class Launcher {

    @SneakyThrows
    public static void main(String[] args) {
        try {
            /* Data */
            float[] positions = {1f, 1f, 1.5f, -0.5f};
            FloatBuffer magnitudes
                = BufferUtils.createFloatBuffer(positions.length / 2);

            /* OpenGL initialization */
            Lwjgl.setup();
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.create();
            GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);

            /* Prepare buffers */
            GlFloatBuffer glPositions =
                new GlFloatBuffer(positions, GL15.GL_ELEMENT_ARRAY_BUFFER);
            GlFloatBuffer glMagnitudes =
                new GlFloatBuffer(magnitudes, GL15.GL_ELEMENT_ARRAY_BUFFER,
                                  GL15.GL_DYNAMIC_DRAW);

            /* Prepare shaders */
            URL magsrc = Launcher.class.getResource("magnitude.glsl");
            URL basesrc = Launcher.class.getResource("base.glsl");
            Shader magnitude = new VertexShader(magsrc);
            Shader base = new FragmentShader(basesrc);

            /* Create program */
            Program program = new Program();
            program.add(magnitude);
            program.add(base);
            program.link();
            System.out.println("Link successful?");

            /* Run it */
            program.attrib(glPositions, "position", 2);
            program.attrib(glMagnitudes, "magnitude", 1);
            program.run();
            System.out.println("Run successful?");
            for (magnitudes.position(0); magnitudes.remaining() > 0;) {
                System.out.println(magnitudes.get());
            }
            Thread.sleep(10000);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0); // Call this or LWJGL crashes
    }
}
