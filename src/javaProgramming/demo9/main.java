package javaProgramming.demo9;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //System.out.println("请输入数字");

        Scanner sc = new Scanner(System.in);
        try{
            int a = sc.nextInt();
            checkNum(a);
        } catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }
    public static void checkNum(int a) throws NegativeNumberException {
        if(a<0){
            throw new NegativeNumberException("输入的数字是"+a+"是负数，不符合要求");
        }else{
            System.out.println("输入成功！你输入的数字是：" + a);
        }
    }
}
