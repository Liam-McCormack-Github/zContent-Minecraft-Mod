package com.zcontent.util;

import com.google.gson.*;
import com.zcontent.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class JsonHelper {
    public static JsonElement getInternalJsonData(String path) throws IOException {
        try (InputStream inputStream = JsonHelper.class.getResourceAsStream(path)) {
            return new JsonParser().parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }
    }

    public static JsonElement getExternalJsonData(String path) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(path))) {
            return new JsonParser().parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }
    }

    public static void createExternalJsonFile(String path, JsonElement data) throws IOException {
        try (Writer writer = new FileWriter(path)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(data, writer);
        }
    }

    public static JsonObject getJsonObject(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null) {
            throw new JsonSyntaxException("Missing config entry for " + memberName + ", expected to find a JsonObject");
        }
        if (element.isJsonObject()) {
            return element.getAsJsonObject();
        } else if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isNumber()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(memberName, element.getAsInt());
            return jsonObject;
        } else {
            throw new JsonSyntaxException("Expected " + memberName + " to be a JsonObject or a number, was " + element);
        }
    }

    public static int getJsonPrimitiveAsInt(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isNumber()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a number, was " + element);
        }
        return element.getAsInt();
    }

    public static String getJsonPrimitiveAsString(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isString()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a string, was " + element);
        }
        return element.getAsString();
    }

    public static boolean getJsonPrimitiveAsBoolean(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isBoolean()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a boolean, was " + element);
        }
        return element.getAsBoolean();
    }

    public static float getJsonPrimitiveAsFloat(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isNumber()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a float, was " + element);
        }
        return element.getAsFloat();
    }

    public static double getJsonPrimitiveAsDouble(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isNumber()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a double, was " + element);
        }
        return element.getAsDouble();
    }

    public static long getJsonPrimitiveAsLong(JsonObject json, String memberName) {
        JsonElement element = json.get(memberName);
        if (element == null || !element.isJsonPrimitive() || !element.getAsJsonPrimitive().isNumber()) {
            throw new JsonSyntaxException("Expected " + memberName + " to be a long, was " + element);
        }
        return element.getAsLong();
    }

    public static int[] getJsonIntArray(JsonObject json, String memberName) {
        JsonArray jsonArray = json.getAsJsonArray(memberName);
        int[] intArray = new int[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            intArray[i] = jsonArray.get(i).getAsInt();
        }
        return intArray;
    }
}
