package com.sysco.webui.common;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadDataProperties {

    // Read a properties file in Java

    public static Map<String,String> loadDataProperties() throws Exception {

        Map<String,String> propertyMap = new HashMap();
        InputStream reader = new FileInputStream(System.getProperty("user.dir") +"/src/main/resources/config.properties");
        Properties p = new Properties();
        p.load(reader);

        Enumeration keys = p.propertyNames();
        while(keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            propertyMap.put(key,p.getProperty(key));
        }

        reader.close();
        return propertyMap;

    }

}
