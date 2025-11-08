package javaProgramming.demo25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.printf("线程[%s]执行任务%d%n", Thread.currentThread().getName(), taskId);
                try {
                    TimeUnit.MILLISECONDS.sleep(500); // 模拟任务执行耗时
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 保留中断状态
                }
            });
        }
        executor.shutdown();
        // 等待线程池终止（最多等10秒）
        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("所有任务执行完成");
        } else {
            System.out.println("部分任务未执行完成，强制关闭");
            executor.shutdownNow(); // 强制中断剩余任务
        }
    }
}