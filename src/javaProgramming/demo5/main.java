package javaProgramming.demo5;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        LeapYear leapYear = new LeapYear();
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(leapYear.getLeapYear(year)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
