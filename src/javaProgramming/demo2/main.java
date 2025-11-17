package javaProgramming.demo2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Add adddemo = new Add();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int a = sc.nextInt();
        System.out.println("请输入第二个数");
        int b = sc.nextInt();
        System.out.println("两个数的和为");
        int tem = adddemo.add(a,b);
        System.out.println(tem);
    }
}
