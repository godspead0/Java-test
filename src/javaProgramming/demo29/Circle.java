package javaProgramming.demo29;

public class Circle implements Shape {
    private double radius;
    private static final double PI = 3.141592653589793;
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("半径必须大于0");
        }
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    public String getShapeName() {
        return "圆形";
    }

    public void displayInfo() {
        System.out.println("=== 圆形信息 ===");
        System.out.println("图形名称: " + getShapeName());
        System.out.println("半径: " + radius);
        System.out.println("面积: " + String.format("%.2f", calculateArea()));
        System.out.println("周长: " + String.format("%.2f", calculatePerimeter()));
    }
}