package javaProgramming.demo12;

public class main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 10;i ++){
            System.out.println((char)('A'+i));
        }
    }
}