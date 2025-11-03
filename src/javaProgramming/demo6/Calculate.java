package javaProgramming.demo6;

public class Calculate {
    double calculate(double num1,double num2,char operator){
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("除数不能为零");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("无效的运算符，请使用 +、-、*、/");
        }
    }
}
