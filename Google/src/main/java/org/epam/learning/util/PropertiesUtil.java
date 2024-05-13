package org.epam.learning.util;

import java.io.IOException;
import java.util.Properties;

/**
 * restfu-booker
 * Author: Vasylenko Oleksii
 * Date: 21.04.2024
 */
public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private PropertiesUtil() {
    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            System.err.println("FAILED TO LOAD PROPERTIES!!!");
            throw new RuntimeException(e);
        }
    }
}
