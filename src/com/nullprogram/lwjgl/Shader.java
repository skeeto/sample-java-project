package com.nullprogram.lwjgl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL20;

/**
 * An OpenGL shader. Call dispose() on the shader to delete the shader
 * and free up GPU resources.
 */
@EqualsAndHashCode(of = "handle")
public abstract class Shader {

    /** Byte array read buffer size. */
    private static final int BUFFER_SIZE = 1024;

    /** The handle for this shader. */
    @Getter
    private final int handle;

    /** True if this shader has been deleted already. */
    private boolean disposed = false;

    /**
     * Create and compile a new shader from a string.
     * @param type    the type of this shader
     * @param source  the source string
     * @throws LWJGLException on compilation error
     */
    public Shader(final int type, final String source) throws LWJGLException {
        handle = compile(type, source);
    }

    /**
     * Create and compile a new shader from a string.
     * @param type  the type of this shader
     * @param file  the source file
     * @throws LWJGLException on compilation error
     * @throws IOException if the source could not be read
     */
    public Shader(final int type, final File file)
        throws IOException, LWJGLException {

        this(type, fetch(new FileInputStream(file)));
    }

    /**
     * Create and compile a new shader from a string.
     * @param type       the type of this shader
     * @param resource   the source resource
     * @throws LWJGLException on compilation error
     * @throws IOException if the source could not be read
     */
    public Shader(final int type, final URL resource)
        throws IOException, LWJGLException {

        this(type, fetch(resource.openStream()));
    }

    /**
     * Disposes of this shader and the system resources it is using.
     */
    public void dispose() {
        if (!disposed) {
            GL20.glDeleteShader(handle);
            disposed = true;
        }
    }

    @Override
    public void finalize() {
        dispose();
    }

    /**
     * Compile the shader code and return the handle.
     * @param type    the type of this shader
     * @param source  the shader source code
     * @return the shader's handle
     * @throws LWJGLException when compilation fails
     */
    private static int compile(final int type, final String source)
        throws LWJGLException {

        int shader = GL20.glCreateShader(type);
        GL20.glShaderSource(shader, source);
        GL20.glCompileShader(shader);
        if (GL20.glGetShader(shader, GL20.GL_COMPILE_STATUS) == 0) {
            /* Compile failed. */
            int len = GL20.glGetShader(shader, GL20.GL_INFO_LOG_LENGTH);
            String info = GL20.glGetShaderInfoLog(shader, len);
            GL20.glDeleteShader(shader);
            throw new LWJGLException(info);
        }
        return shader;
    }

    /**
     * Read the given input into a byte array.
     * @param in  the input stream to be read
     * @return the byte array containing the resource
     * @throws java.io.IOException on IO error
     */
    private static String fetch(final InputStream in)
        throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
        }
        out.close();
        return new String(out.toByteArray());
    }
}
