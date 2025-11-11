package javaProgramming.demo32;

import java.util.Scanner;
import java.util.Random;

public class main {
    private static BankSystem bankSystem = new BankSystem();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("=== 银行账户管理系统 ===");
        System.out.println("当前账户数量: " + bankSystem.getAccountCount());
        startInteractiveMenu();
    }
    
    // 交互式菜单
    private static void startInteractiveMenu() {
        while (true) {
            System.out.println("\n=== 主菜单 ===");
            System.out.println("1. 创建账户");
            System.out.println("2. 存款");
            System.out.println("3. 取款");
            System.out.println("4. 查询余额");
            System.out.println("5. 显示所有账户");
            System.out.println("6. 多线程测试");
            System.out.println("0. 退出系统");
            System.out.print("请选择操作 (0-6): ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 消耗换行符
                
                switch (choice) {
                    case 0:
                        System.out.println("感谢使用银行账户管理系统");
                        return;
                    case 1:
                        createAccountInteractive();
                        break;
                    case 2:
                        depositInteractive();
                        break;
                    case 3:
                        withdrawInteractive();
                        break;
                    case 4:
                        getBalanceInteractive();
                        break;
                    case 5:
                        bankSystem.displayAllAccounts();
                        break;
                    case 6:
                        startMultiThreadTest();
                        break;
                    default:
                        System.out.println("无效选择，请输入 0-6 之间的数字");
                }
            } else {
                System.out.println("请输入有效的数字");
                scanner.next();
            }
        }
    }
    
    // 交互式创建账户
    private static void createAccountInteractive() {
        System.out.println("\n创建新账户");
        System.out.print("请输入账户ID: ");
        String accountId = scanner.nextLine().trim();
        System.out.print("请输入用户名: ");
        String userName = scanner.nextLine().trim();
        System.out.print("请输入初始余额: ");
        
        double initialBalance = -1;
        while (initialBalance < 0) {
            if (scanner.hasNextDouble()) {
                initialBalance = scanner.nextDouble();
                scanner.nextLine(); // 消耗换行符
                if (initialBalance < 0) {
                    System.out.print("初始余额不能为负数，请重新输入: ");
                }
            } else {
                System.out.print("请输入有效的金额: ");
                scanner.next(); // 清除无效输入
            }
        }
        bankSystem.createAccount(accountId, userName, initialBalance);
    }

    private static void depositInteractive() {
        System.out.println("\n存款操作");
        System.out.print("请输入账户ID: ");
        String accountId = scanner.nextLine().trim();
        System.out.print("请输入存款金额: ");
        
        double amount = -1;
        while (amount <= 0) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); // 消耗换行符
                if (amount <= 0) {
                    System.out.print("存款金额必须大于0，请重新输入: ");
                }
            } else {
                System.out.print("请输入有效的金额: ");
                scanner.next(); // 清除无效输入
            }
        }
        
        bankSystem.deposit(accountId, amount);
    }

    private static void withdrawInteractive() {
        System.out.println("\n取款操作");
        System.out.print("请输入账户ID: ");
        String accountId = scanner.nextLine().trim();
        System.out.print("请输入取款金额: ");
        
        double amount = -1;
        while (amount <= 0) {
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine(); // 消耗换行符
                if (amount <= 0) {
                    System.out.print("取款金额必须大于0，请重新输入: ");
                }
            } else {
                System.out.print("请输入有效的金额: ");
                scanner.next(); // 清除无效输入
            }
        }
        
        bankSystem.withdraw(accountId, amount);
    }

    private static void getBalanceInteractive() {
        System.out.println("\n查询余额");
        System.out.print("请输入账户ID: ");
        String accountId = scanner.nextLine().trim();
        
        Double balance = bankSystem.getBalance(accountId);
        if (balance != null) {
            System.out.println("账户 " + accountId + " 的余额为: " + balance);
        }
    }

    private static void startMultiThreadTest() {
        System.out.println("\n=== 开始多线程测试 ===");

        String testAccountId = "TEST001";
        if (!bankSystem.accountExists(testAccountId)) {
            bankSystem.createAccount(testAccountId, "测试用户", 1000.0);
        }

        Thread[] threads = new Thread[5];
        
        // 线程1-2：存款线程
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(new DepositTask(testAccountId, 100 + i * 50), "存款线程-" + (i+1));
        }
        
        // 线程3-4：取款线程
        for (int i = 2; i < 4; i++) {
            threads[i] = new Thread(new WithdrawTask(testAccountId, 50 + (i-2) * 25), "取款线程-" + (i-1));
        }
        
        // 线程5：查询线程（多次查询）
        threads[4] = new Thread(new QueryTask(testAccountId, 3), "查询线程");
        
        // 启动所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        
        // 等待所有线程完成
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("=== 多线程测试完成 ===");
        System.out.println("最终账户信息:");
        Double finalBalance = bankSystem.getBalance(testAccountId);
        if (finalBalance != null) {
            System.out.println("账户 " + testAccountId + " 最终余额: " + finalBalance);
        }
    }

    static class DepositTask implements Runnable {
        private String accountId;
        private double amount;
        
        public DepositTask(String accountId, double amount) {
            this.accountId = accountId;
            this.amount = amount;
        }

        public void run() {
            try {
                // 随机延迟，模拟真实场景
                Thread.sleep(random.nextInt(500));
                bankSystem.deposit(accountId, amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WithdrawTask implements Runnable {
        private String accountId;
        private double amount;
        
        public WithdrawTask(String accountId, double amount) {
            this.accountId = accountId;
            this.amount = amount;
        }

        public void run() {
            try {
                // 随机延迟，模拟真实场景
                Thread.sleep(random.nextInt(500));
                bankSystem.withdraw(accountId, amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class QueryTask implements Runnable {
        private String accountId;
        private int queryCount;
        
        public QueryTask(String accountId, int queryCount) {
            this.accountId = accountId;
            this.queryCount = queryCount;
        }

        public void run() {
            try {
                for (int i = 0; i < queryCount; i++) {
                    Thread.sleep(random.nextInt(300));
                    bankSystem.getBalance(accountId);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}