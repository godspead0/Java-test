package javaProgramming.demo7;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        System.out.println("请输入存款");
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        BankAccount mem = new BankAccount(base);
        while(true) {
            System.out.println("请输入要执行的操作");
            System.out.println("0.存钱");
            System.out.println("1.取钱");
            System.out.println("2.查询余额");
            System.out.println("3.退出");
            Scanner sc1 = new Scanner(System.in);
            int flag = sc1.nextInt();
            switch (flag) {
                case 0:
                    System.out.println("请输入存入多少钱");
                    Scanner sc2 = new Scanner(System.in);
                    double deposit = sc2.nextDouble();
                    mem.Deposit(deposit);
                    break;
                case 1:
                    System.out.println("请输入要取多少钱");
                    Scanner sc3 = new Scanner(System.in);
                    double withdraw = sc3.nextDouble();
                    mem.Withdraw(withdraw);
                    break;
                case 2:
                    mem.checkBalance();
                    break;
                case 3:
                    break;
            }
            if(flag == 3) break;
        }
    }
}
