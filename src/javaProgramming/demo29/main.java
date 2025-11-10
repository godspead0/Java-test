package javaProgramming.demo29;

import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeManager shapeManager = new ShapeManager();
        
        System.out.println("图形计算系统");
        System.out.println("================");
        
        while (true) {
            System.out.println("\n请选择操作:");
            System.out.println("1. 创建新图形");
            System.out.println("2. 显示所有图形信息");
            System.out.println("3. 退出程序");
            System.out.print("请输入选择 (1-3): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    shapeManager.interactiveCreateShape(scanner);
                    break;
                case "2":
                    shapeManager.displayAllShapes();
                    break;
                case "3":
                    System.out.println("感谢使用图形计算系统！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
    }
}