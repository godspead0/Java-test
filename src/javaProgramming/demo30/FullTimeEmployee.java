package javaProgramming.demo30;

public class FullTimeEmployee extends Employee {
    private double performanceBonus;
    public FullTimeEmployee(String ID, String name, double baseSalary, double performanceBonus) {
        super(ID, name, baseSalary);
        this.performanceBonus = performanceBonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + performanceBonus;
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }
    
    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    public String toString() {
        return String.format("全职员工 - %s, 绩效奖金: %.2f", 
                           super.getEmployeeInfo(), performanceBonus);
    }
}