package javaProgramming.demo21;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;
    public static void main(String[] args) {
        System.out.println("=== TCP客户端启动 ===");
        System.out.println("正在连接到服务器: " + SERVER_HOST + ":" + SERVER_PORT);
        
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("连接服务器成功!");
            
            // 启动消息接收线程
            MessageReceiver receiver = new MessageReceiver(reader);
            receiver.start();
            
            // 处理用户输入
            String userInput;
            System.out.println("\n请输入消息 (输入 'exit' 退出):");
            
            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine();
                
                if ("exit".equalsIgnoreCase(userInput.trim())) {
                    writer.println("exit");
                    break;
                }
                
                // 发送消息到服务器
                writer.println(userInput);
            }
            
            // 等待接收线程结束
            receiver.stopReceiving();
            receiver.join(1000);
            
        } catch (UnknownHostException e) {
            System.err.println("无法找到服务器: " + e.getMessage());
        } catch (ConnectException e) {
            System.err.println("连接服务器失败，请确保服务器已启动");
        } catch (IOException e) {
            System.err.println("客户端错误: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("线程中断: " + e.getMessage());
        }
        
        System.out.println("客户端已退出");
    }

    private static class MessageReceiver extends Thread {
        private BufferedReader reader;
        private volatile boolean running = true;
        
        public MessageReceiver(BufferedReader reader) {
            this.reader = reader;
        }
        
        public void stopReceiving() {
            running = false;
            this.interrupt();
        }
        
        @Override
        public void run() {
            try {
                while (running) {
                    String serverResponse = reader.readLine();
                    if (serverResponse == null) {
                        System.out.println("\n服务器连接已断开");
                        break;
                    }
                    System.out.println("\n[服务器] " + serverResponse);
                    System.out.print("> ");
                }
            } catch (IOException e) {
                if (running) {
                    System.err.println("接收消息错误: " + e.getMessage());
                }
            }
        }
    }
}