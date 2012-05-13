package com.nullprogram.lwjgl;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL20;

public class Program {

    @Getter
    private final int handle = GL20.glCreateProgram();

    private boolean disposed = false;

    @Getter
    private Set<Shader> shaders = new HashSet<Shader>();

    public Program add(Shader shader) {
        if (shaders.add(shader)) {
            GL20.glAttachShader(handle, shader.getHandle());
        }
        return this;
    }

    public void detach(Shader shader) {
        if (shaders.remove(shader)) {
            GL20.glDetachShader(handle, shader.getHandle());
        }
    }

    public Program attrib(GlFloatBuffer buffer, String name, int size) {
        int attrib = GL20.glGetAttribLocation(handle, name);
        if (attrib < 1) {
            throw new IllegalStateException("Unknown attrib \"" + name + "\"");
        }
        GL20.glVertexAttribPointer(attrib, size, false, size,
                                   (FloatBuffer) buffer.getBuffer());
        return this;
    }

    public void link() throws LWJGLException {
        GL20.glLinkProgram(handle);
        if (GL20.glGetProgram(handle, GL20.GL_LINK_STATUS) == 0) {
            /* Link failed. */
            int len = GL20.glGetProgram(handle, GL20.GL_INFO_LOG_LENGTH);
            String info = GL20.glGetProgramInfoLog(handle, len);
            throw new LWJGLException(info);
        }
    }

    public void run() {
        GL20.glUseProgram(handle);
    }

    public void dispose() {
        if (!disposed) {
            GL20.glDeleteProgram(handle);
        }
    }

    @Override
    protected void finalize() {
        dispose();
    }
}
