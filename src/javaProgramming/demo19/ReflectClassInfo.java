package javaProgramming.demo19;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ReflectClassInfo {
    public static void getDetails(Class<?> clazz){
        System.out.println("输出全类名");
        System.out.println(clazz.getName());
        System.out.println("输出类内所有方法");
        Method[] methods = clazz.getDeclaredMethods();
        if(methods==null){
            System.out.println("该类无方法");
        }else{
            System.out.println("该类的方法如下");
            for(Method method:methods){
                System.out.println(method.getName());
            }
        }
        System.out.println("输出所有的属性");
        Field[] fields = clazz.getDeclaredFields();
        if(fields==null){
            System.out.println("该类无属性");
        }else{
            System.out.println("该类的属性如下");
            for(Field field:fields){
                System.out.println(field.getName());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("输出样例");
        getDetails(TestClass.class);
        System.out.println("请输入一个全类名（包名加类名，比如：javaProgramming.demo19.TestClass）");
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine().trim();
        Class<?> clazz = Class.forName(fullName);
        getDetails(clazz);
    }
}
