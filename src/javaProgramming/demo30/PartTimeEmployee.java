package javaProgramming.demo30;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(String ID, String name, double hourlyRate, int hoursWorked) {
        super(ID, name, 0); // 兼职员工没有基础工资
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    public int getHoursWorked() {
        return hoursWorked;
    }
    
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String toString() {
        return String.format("兼职员工 - %s, 时薪: %.2f, 工作小时: %d", 
                           super.getEmployeeInfo(), hourlyRate, hoursWorked);
    }
}