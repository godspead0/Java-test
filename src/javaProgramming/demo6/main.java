package javaProgramming.demo6;

import java.util.Scanner;
public class main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        double num1 = scanner.nextDouble();
        System.out.print("请输入运算符（+、-、*、/）：");
        char operator = scanner.next().charAt(0);
        System.out.print("请输入第二个数字：");
        double num2 = scanner.nextDouble();
        Calculate calculate = new Calculate();
        double result = calculate.calculate(num1, num2, operator);
        System.out.printf("计算结果：%.2f %c %.2f = %.2f%n", num1, operator, num2, result);
    }
}
