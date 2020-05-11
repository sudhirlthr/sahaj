package com.sudhir.hotelautomation.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class PropertyFileUtility {

    private static Config getPropertyConfig(){
        Config config = ConfigFactory.load();
        return config;
    }

    private static String getEnumProperty(final Config conf, final String key) {

        if (conf == null) {
            return null;
        }

        if (!conf.hasPath(key)) {
            return null;
        }

        final String keyValue = conf.getString(key);

        if (keyValue == null || keyValue.isEmpty()) {
            return null;
        }

        return keyValue;
    }

    public static Integer getEnumParameterValue(String key){
        Config config = getPropertyConfig();
        String instrumentPowerValue = getEnumProperty(config, key);
        if (instrumentPowerValue != null)
            return Integer.parseInt(instrumentPowerValue);
        else
            return null;
    }
}
