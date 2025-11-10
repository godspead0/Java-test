package javaProgramming.demo29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeManager {
    private List<Shape> shapes;

    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
            System.out.println("成功添加图形: " + shape.getShapeName());
        }
    }

    public void displayAllShapes() {
        if (shapes.isEmpty()) {
            System.out.println("当前没有图形数据");
            return;
        }
        
        System.out.println("\n=== 所有图形信息 ===");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println("图形 " + (i + 1) + ":");
            shapes.get(i).displayInfo();
            System.out.println();
        }
    }

    public List<Shape> findShapesByName(String shapeName) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getShapeName().equals(shapeName)) {
                result.add(shape);
            }
        }
        return result;
    }

    public void interactiveCreateShape(Scanner scanner) {
        System.out.println("\n=== 创建新图形 ===");
        System.out.println("请选择图形类型:");
        System.out.println("1. 圆形");
        System.out.println("2. 矩形");
        System.out.println("3. 三角形");
        System.out.print("请输入选择 (1-3): ");
        
        String choice = scanner.nextLine();
        
        try {
            switch (choice) {
                case "1":
                    createCircle(scanner);
                    break;
                case "2":
                    createRectangle(scanner);
                    break;
                case "3":
                    createTriangle(scanner);
                    break;
                default:
                    System.out.println("无效选择");
            }
        } catch (Exception e) {
            System.out.println("创建图形失败: " + e.getMessage());
        }
    }

    private void createCircle(Scanner scanner) {
        System.out.print("请输入圆的半径: ");
        double radius = Double.parseDouble(scanner.nextLine());
        addShape(new Circle(radius));
    }

    private void createRectangle(Scanner scanner) {
        System.out.print("请输入矩形的长度: ");
        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("请输入矩形的宽度: ");
        double width = Double.parseDouble(scanner.nextLine());
        addShape(new Rectangle(length, width));
    }

    private void createTriangle(Scanner scanner) {
        System.out.print("请输入三角形边A的长度: ");
        double sideA = Double.parseDouble(scanner.nextLine());
        System.out.print("请输入三角形边B的长度: ");
        double sideB = Double.parseDouble(scanner.nextLine());
        System.out.print("请输入三角形边C的长度: ");
        double sideC = Double.parseDouble(scanner.nextLine());
        addShape(new Triangle(sideA, sideB, sideC));
    }
}