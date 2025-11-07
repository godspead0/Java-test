package javaProgramming.demo11;

import java.io.*;
import java.util.Scanner;
// tet是测试文件
public class main {
    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter("D:\\java_test\\tele\\src\\javaProgramming\\demo11\\tet");
        System.out.println("请输入文本");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        out.write(str);
        out.close();
        System.out.println("文件写入完毕");
        System.out.println("开始读取文件");
        FileReader fis = new FileReader("D:\\java_test\\tele\\src\\javaProgramming\\demo11\\tet");
        int flag = 0;
        while((flag=fis.read())!=-1){
            System.out.print((char)flag);
        }
        fis.close();
    }
}
