package javaProgramming.demo24;

import java.io.*;
import java.util.Properties;

public class PropertiesConfigReader {
    private Properties properties;
    public PropertiesConfigReader() {
        this.properties = new Properties();
    }
    public void loadFromFile(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            properties.load(fis);
            System.out.println("成功加载配置文件: " + filename);
        }
    }

    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    public String getStringRequired(String key) throws IllegalArgumentException {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("必需的配置项缺失: " + key);
        }
        return value;
    }

    public int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public long getLong(String key, long defaultValue) {
        try {
            return Long.parseLong(properties.getProperty(key));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void printAllProperties() {
        System.out.println("\n=== 所有配置项 ===");
        for (String key : properties.stringPropertyNames()) {
            System.out.printf("%-30s = %s%n", key, properties.getProperty(key));
        }
    }
}