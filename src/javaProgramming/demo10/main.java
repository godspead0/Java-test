package javaProgramming.demo10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c1 = BankAccount.class;
        Constructor constructor = c1.getDeclaredConstructor(double.class);
        System.out.println("请输入开始有多少钱");
        Scanner sc = new Scanner(System.in);
        double base =sc.nextDouble();
        BankAccount bankAccount = (BankAccount) constructor.newInstance(base);
        System.out.println("请输入要存多少钱");
        double depositAmount = sc.nextDouble();
        Method depositMethod = bankAccount.getClass().getDeclaredMethod("Deposit",double.class);
        depositMethod.invoke(bankAccount,depositAmount);
    }
}
