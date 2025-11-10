package javaProgramming.demo30;

public class SalesEmployee extends Employee {
    private double salesAmount;

    public SalesEmployee(String ID, String name, double baseSalary, double salesAmount) {
        super(ID, name, baseSalary);
        this.salesAmount = salesAmount;
    }

    public double calculateSalary() {
        return getBaseSalary() + (salesAmount * 0.05);
    }

    public double getSalesAmount() {
        return salesAmount;
    }
    
    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String toString() {
        return String.format("销售员工 - %s, 销售额: %.2f, 提成: %.2f", 
                           super.getEmployeeInfo(), salesAmount, salesAmount * 0.05);
    }
}