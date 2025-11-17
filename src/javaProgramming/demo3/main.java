package javaProgramming.demo3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Area area = new Area();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入半径");
        double r = sc.nextDouble();
        System.out.println("圆的面积为");
        System.out.println(area.getArea(r));
    }
}
