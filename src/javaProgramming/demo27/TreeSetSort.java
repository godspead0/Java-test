package javaProgramming.demo27;

import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println("请输入五个整数");
        for(int i = 0;i < 5;i ++){
            treeSet.add(sc.nextInt());
        }
        System.out.println("排序后的数组为");
        for(Integer integer : treeSet){
            System.out.println(integer+" ");
        }
    }
}
