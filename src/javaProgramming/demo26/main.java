package javaProgramming.demo26;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class main {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("HTTP服务器启动，监听端口：" + PORT);
            System.out.println("访问地址：http://localhost:" + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("新客户端连接：" + clientSocket.getInetAddress());
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("服务器启动失败：" + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8)
                );
                PrintWriter writer = new PrintWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8),
                        true // autoFlush：println后自动刷新缓冲区
                )
        ) {
            String requestLine = reader.readLine();
            if (requestLine == null) {
                return;
            }
            System.out.println("请求行：" + requestLine);

            String[] parts = requestLine.split(" ");
            String method = parts[0];
            String path = parts[1];
            String protocol = parts[2];

            if (!"GET".equalsIgnoreCase(method)) {
                sendResponse(writer, protocol, 405, "Method Not Allowed", "<h1>只支持GET请求</h1>");
                return;
            }

            switch (path) {
                case "/":
                    // 根路径：返回首页
                    String homeHtml = "<html><head><title>首页</title></head><body><h1>欢迎访问原生HTTP服务器</h1><p>支持路径：/、/hello、/user?id=1</p></body></html>";
                    sendResponse(writer, protocol, 200, "OK", homeHtml);
                    break;
                case "/hello":
                    // /hello路径：返回问候
                    String helloHtml = "<html><head><title>Hello</title></head><body><h1>Hello, HTTP GET!</h1></body></html>";
                    sendResponse(writer, protocol, 200, "OK", helloHtml);
                    break;
                default:
                    // 404路径：返回未找到
                    String notFoundHtml = "<html><head><title>404</title></head><body><h1>404 Not Found</h1><p>请求路径不存在：" + path + "</p></body></html>";
                    sendResponse(writer, protocol, 404, "Not Found", notFoundHtml);
                    break;
            }

        } catch (IOException e) {
            System.err.println("处理客户端请求失败：" + e.getMessage());
        } finally {
            try {
                clientSocket.close(); // 关闭客户端连接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendResponse(PrintWriter writer, String protocol, int statusCode, String statusMsg, String responseBody) {
        // 1. 状态行
        writer.println(protocol + " " + statusCode + " " + statusMsg);
        // 2. 响应头（必须包含Content-Type和Content-Length）
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println("Content-Length: " + responseBody.getBytes(StandardCharsets.UTF_8).length);
        writer.println("Server: SimpleJavaHttpServer/1.0"); // 自定义服务器标识
        // 3. 空行（分隔响应头和响应体，必须有！）
        writer.println();
        // 4. 响应体
        writer.println(responseBody);
    }
}