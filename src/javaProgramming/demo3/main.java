package javaProgramming.demo3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Area area = new Area();
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.println(area.getArea(r));
    }
}
