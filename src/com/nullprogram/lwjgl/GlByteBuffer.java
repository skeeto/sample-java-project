package com.nullprogram.lwjgl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL15;

/**
 * OpenGL buffer based on a ByteBuffer.
 */
public class GlByteBuffer extends GlBuffer {

    /**
     * Create a new OpenGL buffer for the given data. The usage hint
     * defaults to GL_STATIC_DRAW.
     * @param data    the data array
     * @param target  the type of buffer
     */
    public GlByteBuffer(final byte[] data, final int target) {
        this(Lwjgl.toBuffer(data), target, GL15.GL_STATIC_DRAW);
    }

    /**
     * Create a new OpenGL buffer for the given data.
     * @param data    the data array
     * @param target  the type of buffer
     * @param usage   usage hint for this buffer
     */
    public GlByteBuffer(final ByteBuffer data,
                        final int target, final int usage) {
        super(GL15.glGenBuffers(), data);
        GL15.glBindBuffer(target, getHandle());
        GL15.glBufferData(target, data, usage);
    }
}
