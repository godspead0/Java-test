package javaProgramming.demo32;

import java.io.*;
import java.util.*;

public class BankSystem {
    private Map<String, BankAccount> accounts;
    
    public BankSystem() {
        this.accounts = new HashMap<>();
    }
    
    // 创建账户（同步方法）
    public synchronized boolean createAccount(String accountId, String userName, double initialBalance) {
        if (accounts.containsKey(accountId)) {
            System.out.println("创建账户失败: 账户ID " + accountId + " 已存在");
            return false;
        }
        
        if (initialBalance < 0) {
            System.out.println("创建账户失败: 初始余额不能为负数");
            return false;
        }
        
        BankAccount account = new BankAccount(accountId, userName, initialBalance);
        accounts.put(accountId, account);
        System.out.println("创建账户成功: " + account);
        return true;
    }
    
    // 存款（同步方法）
    public synchronized boolean deposit(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.out.println("存款失败: 账户 " + accountId + " 不存在");
            return false;
        }
        
        account.deposit(amount);
        return true;
    }
    
    // 取款（同步方法）
    public synchronized boolean withdraw(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.out.println("取款失败: 账户 " + accountId + " 不存在");
            return false;
        }
        
        boolean success = account.withdraw(amount);
        return success;
    }
    
    // 查询余额（同步方法）
    public synchronized Double getBalance(String accountId) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.out.println("查询失败: 账户 " + accountId + " 不存在");
            return null;
        }
        
        return account.getBalance();
    }
    
    // 显示所有账户
    public synchronized void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("暂无银行账户");
            return;
        }
        
        System.out.println("\n所有银行账户信息");
        System.out.println("=".repeat(60));
        int index = 1;
        for (BankAccount account : accounts.values()) {
            System.out.printf("%2d. %s\n", index++, account);
        }
        System.out.println("=".repeat(60));
        System.out.printf("总计: %d 个账户\n", accounts.size());
    }

    // 获取账户数量
    public synchronized int getAccountCount() {
        return accounts.size();
    }
    
    // 检查账户是否存在
    public synchronized boolean accountExists(String accountId) {
        return accounts.containsKey(accountId);
    }
}