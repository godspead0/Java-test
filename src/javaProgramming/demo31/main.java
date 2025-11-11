package javaProgramming.demo31;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== 图书管理系统 ===");
        while(true) {
            System.out.println("0.退出系统");
            System.out.println("1.添加图书");
            System.out.println("2.查看所有图书（排序）");
            System.out.println("3.借书");
            System.out.println("4.还书");
            System.out.println("5.保存到文件");
            System.out.println("6.系统信息");
            System.out.print("请选择操作 (0-6): ");
            
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                sc.nextLine(); // 消耗换行符
                
                switch (num) {
                    case 0:
                        System.out.println("感谢使用图书管理系统");
                        return;
                    case 1:
                        addBookInteractive(library, sc);
                        break;
                    case 2:
                        library.displayAllBooks();
                        break;
                    case 3:
                        borrowBookInteractive(library, sc);
                        break;
                    case 4:
                        returnBookInteractive(library, sc);
                        break;
                    case 5:
                        library.saveBooksToFile();
                        break;
                    case 6:
                        displaySystemInfo(library);
                        break;
                    default:
                        System.out.println("无效选择，请输入 0-6 之间的数字");
                }
            } else {
                System.out.println("请输入有效的数字");
                sc.next();
            }
            
            System.out.println();
        }
    }
    // 交互式添加图书（优化版）
    private static void addBookInteractive(Library library, Scanner sc) {
        System.out.println("\n添加新图书");
        System.out.print("请输入ISBN编号: ");
        String isbn = sc.nextLine().trim();
        System.out.print("请输入书名: ");
        String bookName = sc.nextLine().trim();
        System.out.print("请输入作者: ");
        String author = sc.nextLine().trim();
        System.out.print("请输入库存数量: ");
        int count = -1;
        while (count < 0) {
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                sc.nextLine(); // 消耗换行符
                if (count < 0) {
                    System.out.print("库存不能为负数，请重新输入: ");
                }
            } else {
                System.out.print("请输入有效的数字: ");
                sc.next(); // 清除无效输入
            }
        }
        
        Book book = new Book(bookName, author, isbn, count);
        library.add(book);
    }
    
    // 交互式借书
    private static void borrowBookInteractive(Library library, Scanner sc) {
        System.out.print("\n请输入要借阅的图书ISBN编号: ");
        String isbn = sc.nextLine().trim();
        library.borrowBook(isbn);
    }
    
    // 交互式还书
    private static void returnBookInteractive(Library library, Scanner sc) {
        System.out.print("\n请输入要归还的图书ISBN编号: ");
        String isbn = sc.nextLine().trim();
        library.returnBook(isbn);
    }

    // 显示系统信息
    private static void displaySystemInfo(Library library) {
        System.out.println("当前图书数量: " + library.size() + " 本");
        System.out.println("数据文件: books.txt");
        System.out.println("排序方式: 已经自动按ISBN升序");
    }
}