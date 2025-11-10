package javaProgramming.demo29;

public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("长度和宽度必须大于0");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getShapeName() {
        return "矩形";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== 矩形信息 ===");
        System.out.println("图形名称: " + getShapeName());
        System.out.println("长度: " + length);
        System.out.println("宽度: " + width);
        System.out.println("面积: " + String.format("%.2f", calculateArea()));
        System.out.println("周长: " + String.format("%.2f", calculatePerimeter()));
    }
}