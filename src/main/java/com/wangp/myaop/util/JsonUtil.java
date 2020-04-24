package com.wangp.myaop.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class JsonUtil {

    /**
     * 判断是否为有效的json
     * @param jsonInString
     * @return
     */
    public final static boolean isJSONValid(String jsonInString ) {
        JsonElement jsonElement;
        try {
            jsonElement = new JsonParser().parse(jsonInString);
        } catch (Exception e) {
            return false;
        }
        if (jsonElement == null) {
            return false;
        }
        if (!jsonElement.isJsonObject()) {
            return false;
        }
        return true;
    }

    /**
     * 将json转为map
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(Object json)  throws JsonParseException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<Map<String, Object>>(){}.getType(),new MapTypeAdapter()).create();
        if(json instanceof JsonElement){
            return gson.fromJson((JsonElement)json, new TypeToken<Map<String, Object>>() {
            }.getType());
        }else if (json instanceof String){
            return gson.fromJson((String) json, new TypeToken<Map<String, Object>>() {
            }.getType());
        }else {
            throw new JsonParseException("input json type exception,require JsonElement or String type");
        }
    }
}
