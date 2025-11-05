package javaProgramming.demo18;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("请输入要查询的对象");
        System.out.println("0.ADMIN");
        System.out.println("1.USER");
        System.out.println("2.GUEST");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a==0){
            System.out.println(User.ADMIN.getName()+":"+User.ADMIN.getDesc());
        } else if(a==2) {
            System.out.println(User.GUEST.getName()+":"+User.GUEST.getDesc());
        } else if(a==1) {
            System.out.println(User.USER.getName()+":"+User.USER.getDesc());
        }
        sc.close();
    }
}

enum User{
    ADMIN("管理员","拥有所有权限"),
    USER("用户","拥有读写权限"),
    GUEST("访客","拥有访问权限");

    private String name;
    private String desc;
    User(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }

}
