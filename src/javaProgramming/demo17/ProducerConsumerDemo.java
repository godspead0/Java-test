package javaProgramming.demo17;

import java.util.LinkedList;
import java.util.Queue;

// 1. 共享缓冲区（线程安全）
class Buffer {
    private final Queue<Integer> queue; // 存储产品的队列（FIFO）
    private final int maxSize; // 缓冲区最大容量

    // 初始化缓冲区
    public Buffer(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    // 生产者调用：添加产品到缓冲区
    public synchronized void addProduct(int productId) throws InterruptedException {
        // 缓冲区满时，生产者等待（用while避免虚假唤醒）
        while (queue.size() == maxSize) {
            System.out.printf("[缓冲区满] 生产者%s 等待中... 缓冲区当前大小: %d%n",
                    Thread.currentThread().getName(), queue.size());
            wait(); // 释放锁，进入等待队列
        }

        // 生产产品并添加到缓冲区
        queue.offer(productId);
        System.out.printf("[生产成功] 生产者%s 生产了产品%d，缓冲区大小: %d%n",
                Thread.currentThread().getName(), productId, queue.size());

        notifyAll(); // 唤醒所有等待线程（消费者优先）
    }

    // 消费者调用：从缓冲区取出产品
    public synchronized Integer getProduct() throws InterruptedException {
        // 缓冲区空时，消费者等待
        while (queue.isEmpty()) {
            System.out.printf("[缓冲区空] 消费者%s 等待中... 缓冲区当前大小: %d%n",
                    Thread.currentThread().getName(), queue.size());
            wait(); // 释放锁，进入等待队列
        }

        // 消费产品（从队列头部取出）
        Integer productId = queue.poll();
        System.out.printf("[消费成功] 消费者%s 消费了产品%d，缓冲区大小: %d%n",
                Thread.currentThread().getName(), productId, queue.size());

        notifyAll(); // 唤醒所有等待线程（生产者优先）
        return productId;
    }

    // 获取缓冲区当前大小（仅用于日志，非核心方法）
    public synchronized int getSize() {
        return queue.size();
    }
}

// 2. 生产者线程（实现Runnable接口，更灵活）
class Producer implements Runnable {
    private final Buffer buffer; // 持有共享缓冲区引用
    private final int totalProducts; // 生产总量（终止条件）
    private int producedCount = 0; // 已生产数量

    // 构造方法：传入缓冲区和生产总量
    public Producer(Buffer buffer, int totalProducts) {
        this.buffer = buffer;
        this.totalProducts = totalProducts;
    }

    @Override
    public void run() {
        try {
            while (producedCount < totalProducts) {
                producedCount++;
                int productId = producedCount;
                buffer.addProduct(productId); // 生产产品并加入缓冲区

                // 模拟生产耗时（500ms），避免生产过快
                Thread.sleep(500);
            }
            System.out.printf("[生产结束] 生产者%s 完成所有生产任务（共生产%d个）%n",
                    Thread.currentThread().getName(), totalProducts);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
            System.out.printf("[生产中断] 生产者%s 被中断%n", Thread.currentThread().getName());
        }
    }
}

// 3. 消费者线程（实现Runnable接口）
class Consumer implements Runnable {
    private final Buffer buffer; // 持有共享缓冲区引用
    private final int totalProducts; // 消费总量（与生产总量一致）
    private int consumedCount = 0; // 已消费数量

    // 构造方法：传入缓冲区和消费总量
    public Consumer(Buffer buffer, int totalProducts) {
        this.buffer = buffer;
        this.totalProducts = totalProducts;
    }

    @Override
    public void run() {
        try {
            while (consumedCount < totalProducts) {
                buffer.getProduct(); // 从缓冲区取出产品消费
                consumedCount++;

                // 模拟消费耗时（800ms），避免消费过快
                Thread.sleep(800);
            }
            System.out.printf("[消费结束] 消费者%s 完成所有消费任务（共消费%d个）%n",
                    Thread.currentThread().getName(), totalProducts);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
            System.out.printf("[消费中断] 消费者%s 被中断%n", Thread.currentThread().getName());
        }
    }
}

// 4. 主类（程序入口）
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        int maxBufferSize = 5; // 缓冲区最大容量
        int totalProducts = 20; // 总生产/消费数量
        int producerCount = 2; // 生产者线程数
        int consumerCount = 3; // 消费者线程数

        // 创建共享缓冲区
        Buffer buffer = new Buffer(maxBufferSize);

        // 创建并启动生产者线程
        for (int i = 1; i <= producerCount; i++) {
            Thread producerThread = new Thread(new Producer(buffer, totalProducts), "Producer-" + i);
            producerThread.start();
        }

        // 创建并启动消费者线程
        for (int i = 1; i <= consumerCount; i++) {
            Thread consumerThread = new Thread(new Consumer(buffer, totalProducts), "Consumer-" + i);
            consumerThread.start();
        }
    }
}