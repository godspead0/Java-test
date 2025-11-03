package javaProgramming.demo7;

import java.util.Scanner;
public class BankAccount {
    private double base;
    private double deposit; //存款
    private double withdraw; //取款
    public BankAccount(double base) {
        System.out.println("请输入存款");
        this.base = base;
    }
    public void Deposit(double deposit){
        this.base += deposit;
        System.out.println("存钱成功");
    }
    public void Withdraw(double withdraw){
        this.base -= withdraw;
        System.out.println("取钱成功");
    }
    public void checkBalance(){
        System.out.println("余额为"+this.base);
    }
}
