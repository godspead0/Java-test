package javaProgramming.demo17;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> queue;
    private final int maxSize;
    public Buffer(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }
    public synchronized void addProduct(int productId) throws InterruptedException {
        while (queue.size() == maxSize) {
            System.out.printf("[缓冲区满] 生产者%s 等待中... 缓冲区当前大小: %d%n",
                    Thread.currentThread().getName(), queue.size());
            wait();
        }
        queue.offer(productId);
        System.out.printf("[生产成功] 生产者%s 生产了产品%d，缓冲区大小: %d%n",
                Thread.currentThread().getName(), productId, queue.size());

        notifyAll();
    }

    public synchronized Integer getProduct() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.printf("[缓冲区空] 消费者%s 等待中... 缓冲区当前大小: %d%n",
                    Thread.currentThread().getName(), queue.size());
            wait();
        }
        Integer productId = queue.poll();
        System.out.printf("[消费成功] 消费者%s 消费了产品%d，缓冲区大小: %d%n",
                Thread.currentThread().getName(), productId, queue.size());

        notifyAll();
        return productId;
    }
    public synchronized int getSize() {
        return queue.size();
    }
}
class Producer implements Runnable {
    private final Buffer buffer;
    private final int totalProducts;
    private int producedCount = 0;
    public Producer(Buffer buffer, int totalProducts) {
        this.buffer = buffer;
        this.totalProducts = totalProducts;
    }

    public void run() {
        try {
            while (producedCount < totalProducts) {
                producedCount++;
                int productId = producedCount;
                buffer.addProduct(productId);
                Thread.sleep(500);
            }
            System.out.printf("[生产结束] 生产者%s 完成所有生产任务（共生产%d个）%n",
                    Thread.currentThread().getName(), totalProducts);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("[生产中断] 生产者%s 被中断%n", Thread.currentThread().getName());
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;
    private final int totalProducts;
    private int consumedCount = 0;

    public Consumer(Buffer buffer, int totalProducts) {
        this.buffer = buffer;
        this.totalProducts = totalProducts;
    }

    public void run() {
        try {
            while (consumedCount < totalProducts) {
                buffer.getProduct();
                consumedCount++;
                Thread.sleep(800);
            }
            System.out.printf("[消费结束] 消费者%s 完成所有消费任务（共消费%d个）%n",
                    Thread.currentThread().getName(), totalProducts);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("[消费中断] 消费者%s 被中断%n", Thread.currentThread().getName());
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        int maxBufferSize = 5; // 缓冲区最大容量
        int totalProducts = 20; // 总生产/消费数量
        int producerCount = 2; // 生产者线程数
        int consumerCount = 3; // 消费者线程数
        Buffer buffer = new Buffer(maxBufferSize);
        for (int i = 1; i <= producerCount; i++) {
            Thread producerThread = new Thread(new Producer(buffer, totalProducts), "Producer-" + i);
            producerThread.start();
        }
        for (int i = 1; i <= consumerCount; i++) {
            Thread consumerThread = new Thread(new Consumer(buffer, totalProducts), "Consumer-" + i);
            consumerThread.start();
        }
    }
}