package com.zcontent;

import com.zcontent.config.ConfigLoader;
import com.zcontent.init.ModOreDictBlocks;
import com.zcontent.init.ModOreDictItems;
import com.zcontent.init.ModRecipes;
import com.zcontent.proxy.CommonProxy;
import com.zcontent.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {


    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);


    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        ConfigLoader.load();
        ConfigLoader.init();
        // OreDictionaryHandlerItems.registerOreDictionary();
        ModOreDictItems.init();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        ModOreDictBlocks.init();
        ModRecipes.init();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {

    }
}
