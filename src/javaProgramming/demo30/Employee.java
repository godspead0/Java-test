package javaProgramming.demo30;

public abstract class Employee {
    private String ID;
    private String name;
    private double salary;
    abstract void calculateSalary();
    public void getEmployeeInfo(){
        System.out.println("输出当前员工信息");
        System.out.println("员工ID为："+this.ID);
        System.out.println("员工姓名为："+this.name);
        System.out.println("员工工资为："+this.salary);
    }
}
