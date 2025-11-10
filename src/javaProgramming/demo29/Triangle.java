package javaProgramming.demo29;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("三边长度不能构成有效的三角形");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && 
               (a + b > c) && (a + c > b) && (b + c > a);
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2; // 半周长
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // 海伦公式
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getShapeName() {
        return "三角形";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== 三角形信息 ===");
        System.out.println("图形名称: " + getShapeName());
        System.out.println("边A: " + sideA);
        System.out.println("边B: " + sideB);
        System.out.println("边C: " + sideC);
        System.out.println("面积: " + String.format("%.2f", calculateArea()));
        System.out.println("周长: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("三角形类型: " + getTriangleType());
    }

    public String getTriangleType() {
        if (sideA == sideB && sideB == sideC) {
            return "等边三角形";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return "等腰三角形";
        } else {
            return "三角形";
        }
    }
}