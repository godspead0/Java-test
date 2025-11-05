package javaProgramming.demo15;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入5个数字");
        ArrayList<Integer> List = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List.add(sc.nextInt());
        }
        ArrayList<Integer> DisList = new ArrayList<>(List.stream().distinct().toList());
        System.out.println("去除后的数组为" + DisList);
    }
}
