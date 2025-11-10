package javaProgramming.demo30;

import java.util.Objects;

public abstract class Employee {
    private String ID;
    private String name;
    private double baseSalary;
    public Employee(String ID, String name, double baseSalary) {
        this.ID = ID;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
    public String getEmployeeInfo() {
        return String.format("员工ID: %s, 姓名: %s, 基础工资: %.2f, 实际工资: %.2f", 
                           ID, name, baseSalary, calculateSalary());
    }

    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(ID, employee.ID);
    }

    public int hashCode() {
        return Objects.hash(ID);
    }

    public String toString() {
        return getEmployeeInfo();
    }
}