package javaProgramming.demo8;

import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        ArrayList<Product>  products = new ArrayList<>();
        while(true){
            System.out.println("请输入要执行的操作");
            System.out.println("0.退出");
            System.out.println("1.添加商品");
            System.out.println("2.查询商品");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice==2&products.isEmpty()) {
                System.out.println("操作错误");
                break;
            }else if(choice==1) {
                System.out.println("请输入商品名称，商品价格");
                String name = sc.next();
                Double price = sc.nextDouble();
                Product mem = new Product(name,price);
                products.add(mem);
                mem.SetProductId(products.size());
            }else if(choice==0) {
                break;
            }else if(choice==2) {
                System.out.println("请输入要查询的商品");
                int id = sc.nextInt();
                products.get(id-1).getProduct(products.get(id-1));
            }else{
                break;
            }
            if(choice!=1&&choice!=2) {
                break;
            }
        }
    }
}
