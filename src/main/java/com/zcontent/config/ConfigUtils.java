package com.zcontent.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConfigUtils {

    private static final Map<Integer, Mode> MODES = new HashMap<>();

    static {
        JsonObject config = ConfigLoader.getConfig();
        if (config != null) {
            JsonObject wandsConfig = config.getAsJsonObject("wands");
            if (wandsConfig != null) {
                JsonArray modes = wandsConfig.getAsJsonArray("modes");
                for (int i = 0; i < modes.size(); i++) {
                    JsonObject modeObject = modes.get(i).getAsJsonObject().getAsJsonObject(String.valueOf(i));
                    JsonArray blockNames = modeObject.getAsJsonArray("blockList");
                    boolean isBlacklist = modeObject.get("isBlacklist").getAsBoolean();

                    List<Block> blockList = new ArrayList<>();
                    for (JsonElement blockName : blockNames) {
                        blockList.add(Block.getBlockFromName(blockName.getAsString()));
                    }

                    MODES.put(i, new Mode(blockList, isBlacklist));
                }
            }
        }
    }

    public static Mode getMode(int id) {
        return MODES.get(id);
    }

    public static class Mode {
        public List<Block> blockList;
        public boolean isBlacklist;

        Mode(List<Block> blockList, boolean isBlacklist) {
            this.blockList = blockList;
            this.isBlacklist = isBlacklist;
        }
    }

}
