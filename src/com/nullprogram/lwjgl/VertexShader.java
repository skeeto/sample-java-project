package com.nullprogram.lwjgl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL20;

/**
 * An OpenGL vertex shader.
 */
public class VertexShader extends Shader {

    /**
     * Create and compile a new shader from a string.
     * @param source  the source string
     * @throws LWJGLException on compilation error
     */
    public VertexShader(final String source) throws LWJGLException {
        super(GL20.GL_VERTEX_SHADER, source);
    }

    /**
     * Create and compile a new shader from a string.
     * @param file  the source file
     * @throws LWJGLException on compilation error
     * @throws IOException if the source could not be read
     */
    public VertexShader(final File file) throws IOException, LWJGLException {
        super(GL20.GL_VERTEX_SHADER, file);
    }

    /**
     * Create and compile a new shader from a string.
     * @param url  the source resource
     * @throws LWJGLException on compilation error
     * @throws IOException if the source could not be read
     */
    public VertexShader(final URL url) throws IOException, LWJGLException {
        super(GL20.GL_VERTEX_SHADER, url);
    }
}
