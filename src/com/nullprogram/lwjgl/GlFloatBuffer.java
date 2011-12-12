package com.nullprogram.lwjgl;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL15;

/**
 * OpenGL buffer based on a FloatBuffer.
 */
public class GlFloatBuffer extends GlBuffer<FloatBuffer> {

    /**
     * Create a new OpenGL buffer for the given data. The usage hint
     * defaults to GL_STATIC_DRAW.
     * @param data    the data array
     * @param target  the type of buffer
     */
    public GlFloatBuffer(final float[] data, final int target) {
        this(Lwjgl.toBuffer(data), target, GL15.GL_STATIC_DRAW);
    }

    /**
     * Create a new OpenGL buffer for the given data.
     * @param data    the data array
     * @param target  the type of buffer
     * @param usage   usage hint for this buffer
     */
    public GlFloatBuffer(final FloatBuffer data,
                        final int target, final int usage) {
        super(GL15.glGenBuffers(), data);
        GL15.glBindBuffer(target, getHandle());
        GL15.glBufferData(target, getBuffer(), usage);
    }
}
