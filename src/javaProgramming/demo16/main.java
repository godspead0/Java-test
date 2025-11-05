package javaProgramming.demo16;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] arr1 = new Integer[5];
        Integer[] arr2 = new Integer[5];
        System.out.println("请升序输入五个数字");
        for(int i = 0;i < 5;i ++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("请升序输入五个数字");
        for(int i = 0;i < 5;i ++){
            arr2[i] = sc.nextInt();
        }
        Integer[] arr3 = Stream.concat(
                Arrays.stream(arr1),
                Arrays.stream(arr2)
        ).sorted().toArray(Integer[]::new);
        System.out.println("排序后的数组如下" + Arrays.toString(arr3));
    }
}
