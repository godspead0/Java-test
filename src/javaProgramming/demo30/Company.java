package javaProgramming.demo30;

import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private List<Employee> employees;
    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            System.out.println("添加员工成功: " + employee.getName());
        } else {
            System.out.println("员工已存在: " + employee.getName());
        }
    }

    public boolean removeEmployee(String employeeID) {
        return employees.removeIf(emp -> emp.getID().equals(employeeID));
    }

    // stream流处理数据
    public double calculateTotalSalary() {
        return employees.stream()
                       .mapToDouble(Employee::calculateSalary)
                       .sum();
    }

    public void displayEmployeesSortedBySalary() {
        List<Employee> sortedEmployees = employees.stream()
                                                 .sorted(Comparator.comparingDouble(Employee::calculateSalary))
                                                 .collect(Collectors.toList());
        
        System.out.println("\n=== 按工资从低到高排序的员工信息 ===");
        sortedEmployees.forEach(emp -> System.out.println(emp));
    }

    public Optional<Employee> getHighestPaidEmployee() {
        return employees.stream()
                       .max(Comparator.comparingDouble(Employee::calculateSalary));
    }

    public Optional<Employee> getLowestPaidEmployee() {
        return employees.stream()
                       .min(Comparator.comparingDouble(Employee::calculateSalary));
    }

    public void displaySalaryStatistics() {
        DoubleSummaryStatistics stats = employees.stream()
                                               .mapToDouble(Employee::calculateSalary)
                                               .summaryStatistics();
        
        System.out.println("\n=== 工资统计信息 ===");
        System.out.printf("员工总数: %d\n", stats.getCount());
        System.out.printf("总工资: %.2f\n", stats.getSum());
        System.out.printf("平均工资: %.2f\n", stats.getAverage());
        System.out.printf("最高工资: %.2f\n", stats.getMax());
        System.out.printf("最低工资: %.2f\n", stats.getMin());
    }

    public int getEmployeeCount() {
        return employees.size();
    }
}