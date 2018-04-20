package com.nullprogram.lwjgl;

import com.nullprogram.guide.Arch;
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
    public static void setup() throws java.io.IOException { //test
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
}
