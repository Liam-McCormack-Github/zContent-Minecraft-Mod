package com.zcontent.config;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;

public class JsonUtils {
    public static JsonElement getInternalJsonData(String path) throws IOException {
        try (InputStream inputStream = JsonUtils.class.getResourceAsStream(path)) {
            return new JsonParser().parse(new InputStreamReader(inputStream, "UTF-8"));
        }
    }

    public static JsonElement getExternalJsonData(String path) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(path))) {
            return new JsonParser().parse(new InputStreamReader(inputStream, "UTF-8"));
        }
    }

    public static void createExternalJsonFile(String path, JsonElement data) throws IOException {
        try (Writer writer = new FileWriter(path)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(data, writer);
        }
    }
}
