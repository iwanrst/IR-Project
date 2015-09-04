package com.ir.engine.com.ir.engine.util;

/**
 * Created by Iwan R on 8/29/2015.
 */
import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
