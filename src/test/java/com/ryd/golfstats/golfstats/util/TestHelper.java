package com.ryd.golfstats.golfstats.util;

import com.google.gson.Gson;

public class TestHelper {

    private TestHelper(){}

    public static String toJson(Object object){
        return new Gson().toJson(object);
    }
}
