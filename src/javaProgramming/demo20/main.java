package javaProgramming.demo20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要统计的文件路径: ");
        String filePath = scanner.nextLine();
        try {
            int wordCount = WordCounter.countWordsInFile(filePath);
            System.out.println("文件 '" + filePath + "' 中的单词数量为: " + wordCount);
        } catch (IOException e) {
            System.out.println("读取文件时出错: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生错误: " + e.getMessage());
        }
        
        scanner.close();
    }
}