package com.zcontent.config;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zcontent.util.Reference;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigLoader {
    private static final String INTERNAL_CONFIG_PATH = "/assets/zcontent/zcontent_config.json";
    private static final String EXTERNAL_CONFIG_PATH = Reference.getGameFolder() + "/config/zcontent_config.json";

    private static JsonObject configuration;

    public static void load() {
        try {
            JsonObject internalConfig = JsonUtils.getInternalJsonData(INTERNAL_CONFIG_PATH).getAsJsonObject();
            if (Files.exists(Paths.get(EXTERNAL_CONFIG_PATH))) {
                configuration = JsonUtils.getExternalJsonData(EXTERNAL_CONFIG_PATH).getAsJsonObject();
            } else {
                configuration = internalConfig;
                JsonUtils.createExternalJsonFile(EXTERNAL_CONFIG_PATH, internalConfig);
            }
        } catch (IOException exception) {
            System.err.println("Failed to load configuration files!");
            exception.printStackTrace();
        }
    }

    public static void save() {
        try (Writer writer = new FileWriter(EXTERNAL_CONFIG_PATH)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(configuration, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void init() {
        // Add default mode to wand config
        if (configuration != null) {
            JsonObject wandsConfig = configuration.getAsJsonObject("wands");
            if (wandsConfig != null) {
                JsonArray modesArray = wandsConfig.getAsJsonArray("modes");

                // Create the new mode object
                JsonObject newMode = new JsonObject();
                newMode.add("blockList", new JsonArray());
                newMode.addProperty("isBlacklist", true);

                // Create a new JsonArray and insert the new mode at the start
                JsonArray newModesArray = new JsonArray();
                newModesArray.add(newMode);

                // Add the existing modes to the new array
                newModesArray.addAll(modesArray);

                // Replace the old "modes" array with the new one
                configuration.getAsJsonObject("wands").add("modes", newModesArray);


            }
        }
    }

    public static JsonObject getConfig() {
        return configuration;
    }


}
