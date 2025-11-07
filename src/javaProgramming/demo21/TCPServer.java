package javaProgramming.demo21;

import java.io.*;
import java.net.*;

public class TCPServer {
    private static final int PORT = 8888;
    public static void main(String[] args) {
        System.out.println("=== TCP服务器启动 ===");
        System.out.println("服务器监听端口: " + PORT);
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("等待客户端连接...");
            
            while (true) {
                // 接受客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端连接成功: " + clientSocket.getInetAddress().getHostAddress());
                
                // 为每个客户端创建新的线程处理
                new ClientHandler(clientSocket).start();
            }
            
        } catch (IOException e) {
            System.err.println("服务器启动失败: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;
        
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }
        
        @Override
        public void run() {
            try {
                // 获取输入输出流
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                
                // 发送欢迎消息
                writer.println("欢迎连接到TCP服务器! 输入 'exit' 退出连接。");
                
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("收到客户端消息: " + clientMessage);
                    
                    // 处理退出命令
                    if ("exit".equalsIgnoreCase(clientMessage.trim())) {
                        writer.println("再见!");
                        break;
                    }
                    
                    // 处理特殊命令
                    if ("time".equalsIgnoreCase(clientMessage.trim())) {
                        writer.println("当前时间: " + new java.util.Date());
                    } else if ("help".equalsIgnoreCase(clientMessage.trim())) {
                        writer.println("可用命令: time - 显示时间, help - 显示帮助, exit - 退出连接");
                    } else {
                        // 回显消息
                        String response = "服务器回复: " + clientMessage.toUpperCase();
                        writer.println(response);
                    }
                }
                
            } catch (IOException e) {
                System.err.println("客户端处理错误: " + e.getMessage());
            } finally {
                try {
                    if (clientSocket != null) {
                        clientSocket.close();
                        System.out.println("客户端连接关闭: " + clientSocket.getInetAddress().getHostAddress());
                    }
                } catch (IOException e) {
                    System.err.println("关闭连接时出错: " + e.getMessage());
                }
            }
        }
    }
}