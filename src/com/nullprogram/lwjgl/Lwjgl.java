package com.nullprogram.lwjgl;

import com.nullprogram.guide.Arch;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import static com.nullprogram.guide.NativeGuide.prepare;

/**
 * Prepares all of the LWJGL native binaries for loading.
 */
public final class Lwjgl {

    /** Hidden constructor. */
    private Lwjgl() {
    }

    /**
     * Prepares all of the LWJGL native libraries for loading.
     * @throws java.io.IOException when the libraries could not be loaded
     */
    public static void setup() throws java.io.IOException {
        prepare(Arch.LINUX_64, "/libjinput-linux64.so");
        prepare(Arch.LINUX_32, "/libjinput-linux.so");
        prepare(Arch.LINUX_64, "/liblwjgl64.so");
        prepare(Arch.LINUX_32, "/liblwjgl.so");
        prepare(Arch.LINUX_64, "/libopenal64.so");
        prepare(Arch.LINUX_32, "/libopenal.so");
        prepare(Arch.MAC_64, "/libjinput-osx.jnilib");
        prepare(Arch.MAC_64, "/liblwjgl.jnilib");
        prepare(Arch.MAC_64, "/openal.dylib");
        prepare(Arch.WINDOWS_64, "/jinput-dx8_64.dll");
        prepare(Arch.WINDOWS_32, "/jinput-dx8.dll");
        prepare(Arch.WINDOWS_64, "/jinput-raw_64.dll");
        prepare(Arch.WINDOWS_32, "/jinput-raw.dll");
        prepare(Arch.WINDOWS_64, "/lwjgl64.dll");
        prepare(Arch.WINDOWS_32, "/lwjgl.dll");
        prepare(Arch.WINDOWS_32, "/OpenAL32.dll");
        prepare(Arch.WINDOWS_64, "/OpenAL64.dll");
    }

    /**
     * Make a new direct FloatBuffer based on a float array.
     * @param in  the float array to be wrapped
     * @return a direct FloatBuffer
     */
    public static FloatBuffer toBuffer(final float[] in) {
        return BufferUtils.createFloatBuffer(in.length).put(in);
    }

    /**
     * Make a new direct ByteBuffer based on a byte array.
     * @param in  the byte array to be wrapped
     * @return a direct ByteBuffer
     */
    public static ByteBuffer toBuffer(final byte[] in) {
        return BufferUtils.createByteBuffer(in.length).put(in);
    }
}
