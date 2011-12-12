package com.nullprogram.lwjgl;

import java.nio.Buffer;
import lombok.Getter;
import org.lwjgl.opengl.GL15;

/**
 * An OpenGL buffer object, the abstract base class. Because the LWJGL
 * API depends highly on the <i>type</i> of the underlying Buffer, it
 * is generic and each subclass takes on a different Buffer subclass.
 * @param <T>  the type of buffer backing this OpenGL buffer
 */
public abstract class GlBuffer<T extends Buffer> {

    /** OpenGL handle for this buffer. */
    @Getter
    private final int handle;

    /** Native buffer that backs this buffer. */
    @Getter
    private final T buffer;

    /** True of this buffer has been disposed. */
    private boolean disposed = false;

    /**
     * Create a new buffer.
     * @param id    the buffer's handle
     * @param data  the native buffer backing this buffer
     */
    protected GlBuffer(final int id, final T data) {
        handle = id;
        buffer = data;
    }


    /**
     * Disposes of this shader and the system resources it is
     * using. This can be safely called multiple times, but it is not
     * thread-safe.
     */
    public void dispose() {
        if (!disposed) {
            GL15.glDeleteBuffers(handle);
            disposed = true;
        }
    }

    @Override
    protected void finalize() {
        dispose();
    }
}
