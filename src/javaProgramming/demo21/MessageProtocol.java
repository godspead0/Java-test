package javaProgramming.demo21;

public class MessageProtocol {
    public static class MessageType {
        public static final String TEXT = "TEXT";
        public static final String COMMAND = "COMMAND";
        public static final String SYSTEM = "SYSTEM";
    }

    public static class Commands {
        public static final String EXIT = "EXIT";
        public static final String TIME = "TIME";
        public static final String HELP = "HELP";
        public static final String ECHO = "ECHO";
    }
    public static String formatMessage(String type, String content) {
        return String.format("[%s] %s", type, content);
    }
    public static String[] parseMessage(String message) {
        if (message == null || !message.startsWith("[")) {
            return new String[]{MessageType.TEXT, message};
        }
        try {
            int endIndex = message.indexOf("]");
            if (endIndex > 0) {
                String type = message.substring(1, endIndex);
                String content = message.substring(endIndex + 1).trim();
                return new String[]{type, content};
            }
        } catch (Exception e) {
            // 解析失败，返回原始消息
        }
        return new String[]{MessageType.TEXT, message};
    }

    public static boolean isCommand(String message) {
        if (message == null) return false;

        String upperMessage = message.toUpperCase();
        return upperMessage.equals(Commands.EXIT) ||
               upperMessage.equals(Commands.TIME) ||
               upperMessage.equals(Commands.HELP) ||
               upperMessage.equals(Commands.ECHO);
    }

    public static String processCommand(String command) {
        if (command == null) return "无效命令";

        String upperCommand = command.toUpperCase();
        switch (upperCommand) {
            case Commands.TIME:
                return "当前服务器时间: " + new java.util.Date();
            case Commands.HELP:
                return "可用命令: time - 显示时间, help - 显示帮助, exit - 退出连接";
            case Commands.ECHO:
                return "ECHO命令已收到";
            default:
                return "未知命令: " + command;
        }
    }
}