package javaProgramming.demo20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// tet是测试文件
public class WordCounter {
    public static int countWordsInFile(String filePath) throws IOException {
        int wordCount = 0;
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            // 使用正则表达式分割单词：一个或多个字母数字字符
            String[] words = line.trim().split("\\s+");
            for (String word : words) {
                // 过滤掉空字符串和只包含标点符号的"单词"
                if (!word.isEmpty() && word.matches(".*[a-zA-Z0-9].*")) {
                    wordCount++;
                }
            }
        }
        return wordCount;
    }
}