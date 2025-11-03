package javaProgramming.demo2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Add adddemo = new Add();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tem = adddemo.add(a,b);
        System.out.println(tem);
    }
}
