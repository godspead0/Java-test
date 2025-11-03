package javaProgramming.demo6;

import java.util.Scanner;
public class main{
    public static void main(String[] args){
        // 创建 Scanner 对象用于接收用户输入
        Scanner scanner = new Scanner(System.in);

        try {
            // 提示用户输入第一个数字
            System.out.print("请输入第一个数字：");
            double num1 = scanner.nextDouble();

            // 提示用户输入运算符
            System.out.print("请输入运算符（+、-、*、/）：");
            char operator = scanner.next().charAt(0); // 获取输入字符串的第一个字符

            // 提示用户输入第二个数字
            System.out.print("请输入第二个数字：");
            double num2 = scanner.nextDouble();

            // 计算结果
            Calculate calculate = new Calculate();
            double result = calculate.calculate(num1, num2, operator);

            // 输出结果（保留2位小数，格式更美观）
            System.out.printf("计算结果：%.2f %c %.2f = %.2f%n", num1, operator, num2, result);

        } catch (ArithmeticException e) {
            // 捕获除法除数为零的异常
            System.out.println("错误：" + e.getMessage());
        } catch (IllegalArgumentException e) {
            // 捕获无效运算符的异常
            System.out.println("错误：" + e.getMessage());
        } catch (Exception e) {
            // 捕获其他输入错误（如输入非数字）
            System.out.println("错误：输入格式不正确，请输入有效的数字和运算符");
        } finally {
            // 关闭 Scanner 资源
            scanner.close();
        }
    }
}
