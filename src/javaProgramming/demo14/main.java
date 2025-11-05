package javaProgramming.demo14;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入要进行的操作");
            System.out.println("0.执行Integer类型比较");
            System.out.println("1.执行String类型比较");
            System.out.println("2.执行Double类型比较");
            System.out.println("3.执行Student类的类型比较");
            System.out.println("4.退出程序");

            int base = sc.nextInt();
            switch(base){
                case 0:
                    System.out.println("请输入5个整数");
                    Integer[] intArray = new Integer[5];
                    for(int i = 0;i < 5;i++){
                        int a =  sc.nextInt();
                        intArray[i] = a;
                    }
                    System.out.println("Integer数组: " + java.util.Arrays.toString(intArray));
                    System.out.println("最大值: " + ArrayUtils.findMax(intArray));
                    System.out.println();
                    break;
                case 1:
                    System.out.println("请输入5个字符串");
                    sc.nextLine();// 消耗缓冲区换行符
                    String[] stringArray = new String[5];
                    for(int i = 0;i < 5;i ++){
                        String a =  sc.nextLine();
                        stringArray[i] = a;
                    }
                    System.out.println("String数组: " + java.util.Arrays.toString(stringArray));
                    System.out.println("最大值(按字典序): " + ArrayUtils.findMax(stringArray));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("请输入5个浮点数");
                    Double[] doubleArray = new Double[5];
                    for(int i = 0;i < 5;i ++){
                        Double a =  sc.nextDouble();
                        doubleArray[i] = a;
                    }
                    System.out.println("Double数组: " + java.util.Arrays.toString(doubleArray));
                    System.out.println("最大值: " + ArrayUtils.findMax(doubleArray));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("由于类的格式问题，此处不需要输入，程序内已经指定数组");
                    Student[] studentArray = {
                            new Student("张三", 85),
                            new Student("李四", 92),
                            new Student("王五", 78),
                            new Student("赵六", 95)
                    };
                    System.out.println("Student数组:");
                    for (Student student : studentArray) {
                        System.out.println("  " + student);
                    }
                    System.out.println("最高分学生: " + ArrayUtils.findMax(studentArray));
                    System.out.println();
                    break;
                case 4:
                    break;
            }
            if(base == 4) break;
        }
    }
}

// 自定义学生类，实现Comparable接口用于比较
class Student implements Comparable<Student> {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public int compareTo(Student other) {
        // 按分数比较
        return Integer.compare(this.score, other.score);
    }
    public String toString() {
        return name + "(" + score + "分)";
    }
}
