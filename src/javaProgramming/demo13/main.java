package javaProgramming.demo13;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个整数");
        for(int j = 0;j<10;j++){
            int t = sc.nextInt();
            arr.add(t);
        }
        System.out.println("开始逆序输出");
        for(int j = 9;j>=0;j--){
            System.out.print(arr.get(j)+" ");
        }
        System.out.println("\n");
        System.out.println("输出完毕");
    }
}
