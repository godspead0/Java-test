package javaProgramming.demo9;

public class NegativeNumberException extends Exception {
    public NegativeNumberException() {
        super("输入错误：不允许输入负数！");
    }
    public NegativeNumberException(String message) {
        super(message);
    }
}
