package javaProgramming.demo23;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("请输入五个数字");
        int arr[] = new int[5];
        int n = 5;
        for(int i = 0; i < n; i++){
            Scanner sc = new Scanner(System.in);
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("冒泡排序结束");
    }
}
