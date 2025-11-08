package javaProgramming.demo24;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            System.out.println("\n--- 读取系统配置 ---");
            PropertiesConfigReader systemReader = new PropertiesConfigReader();
            systemReader.loadFromFile("src/javaProgramming/demo24/system.properties");
            demonstrateSystemConfig(systemReader);
        } catch (IOException e) {
            System.err.println("配置文件读取错误: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void demonstrateSystemConfig(PropertiesConfigReader reader) {
        String systemName = reader.getString("system.name", "未知系统");
        String version = reader.getString("system.version", "1.0.0");
        int threadPoolSize = reader.getInt("thread.pool.size", 10);
        long memoryLimit = reader.getLong("memory.limit", 256);
        
        System.out.println("系统名称: " + systemName);
        System.out.println("版本: " + version);
        System.out.println("线程池大小: " + threadPoolSize);
        System.out.println("内存限制: " + memoryLimit + "MB");
        
        // 显示所有配置
        reader.printAllProperties();
    }
}