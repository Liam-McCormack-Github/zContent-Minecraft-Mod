package com.zcontent.util;

import net.minecraftforge.fml.relauncher.FMLInjectionData;

import java.io.File;
import java.util.UUID;

public class Reference {

    public static final String MOD_ID = "zcontent";
    public static final String NAME = "zContent";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSION = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.zcontent.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.zcontent.proxy.CommonProxy";


    public static String getGameFolder() {
        return ((File) (FMLInjectionData.data()[6])).getAbsolutePath();
    }

}
