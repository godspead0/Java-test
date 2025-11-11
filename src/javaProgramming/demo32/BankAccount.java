package javaProgramming.demo32;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String accountId;
    private String userName;
    private double balance;
    
    public BankAccount(String accountId, String userName, double initialBalance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = initialBalance;
    }
    
    // 存款方法（线程安全）
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + 
                " 存款成功: " + amount + " | 账户: " + accountId + 
                " | 余额: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + 
                " 存款失败: 金额必须大于0");
        }
    }
    
    // 取款方法（线程安全）
    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                " 取款成功: " + amount + " | 账户: " + accountId + 
                " | 余额: " + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + 
                " 取款失败: 余额不足或金额无效 | 账户: " + accountId + 
                " | 余额: " + balance);
            return false;
        }
    }
    
    // 查询余额方法（线程安全）
    public synchronized double getBalance() {
        System.out.println(Thread.currentThread().getName() + 
            " 查询余额: " + accountId + " | 余额: " + balance);
        return balance;
    }
    
    // Getter方法
    public String getAccountId() {
        return accountId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    @Override
    public String toString() {
        return String.format("账户ID: %s | 用户名: %s | 余额: %.2f", 
                           accountId, userName, balance);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount account = (BankAccount) obj;
        return accountId.equals(account.accountId);
    }
    
    @Override
    public int hashCode() {
        return accountId.hashCode();
    }
}