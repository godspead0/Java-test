package javaProgramming.demo30;

import java.util.*;

// 数据已经内置
public class main {
    public static void main(String[] args) {
        // 创建公司
        Company company = new Company();
        
        // 创建不同类型的员工
        Employee fullTimeEmp1 = new FullTimeEmployee("FT001", "张三", 8000, 2000);
        Employee fullTimeEmp2 = new FullTimeEmployee("FT002", "李四", 10000, 3000);
        
        Employee partTimeEmp1 = new PartTimeEmployee("PT001", "王五", 50, 80);
        Employee partTimeEmp2 = new PartTimeEmployee("PT002", "赵六", 60, 100);
        
        Employee salesEmp1 = new SalesEmployee("SE001", "钱七", 5000, 100000);
        Employee salesEmp2 = new SalesEmployee("SE002", "孙八", 6000, 150000);
        
        // 添加员工到公司
        company.addEmployee(fullTimeEmp1);
        company.addEmployee(fullTimeEmp2);
        company.addEmployee(partTimeEmp1);
        company.addEmployee(partTimeEmp2);
        company.addEmployee(salesEmp1);
        company.addEmployee(salesEmp2);
        
        System.out.println("\n=== 员工工资管理系统 ===");
        double totalSalary = company.calculateTotalSalary();
        System.out.printf("所有员工总工资: %.2f\n", totalSalary);

        company.displayEmployeesSortedBySalary();
        company.displaySalaryStatistics();
        company.getHighestPaidEmployee().ifPresent(emp -> 
            System.out.println("\n工资最高的员工: " + emp));
        company.getLowestPaidEmployee().ifPresent(emp -> 
            System.out.println("工资最低的员工: " + emp));
        System.out.println("\n=== equals和hashCode方法 ===");
        Employee testEmp1 = new FullTimeEmployee("FT001", "张三", 8000, 2000);
        Employee testEmp2 = new FullTimeEmployee("FT001", "张三", 8000, 2000);
        System.out.println("testEmp1.equals(testEmp2): " + testEmp1.equals(testEmp2));
        System.out.println("testEmp1.hashCode(): " + testEmp1.hashCode());
        System.out.println("testEmp2.hashCode(): " + testEmp2.hashCode());
        System.out.println("\n=== 删除员工演示 ===");
        boolean removed = company.removeEmployee("PT001");
        System.out.println("删除PT001员工: " + (removed ? "成功" : "失败"));
        System.out.println("当前员工数量: " + company.getEmployeeCount());
        company.displayEmployeesSortedBySalary();
    }
}