package javaProgramming.demo31;

import java.io.*;
import java.util.*;

public class Library {
    private ArrayList<Book> books;
    
    public Library(){
        this.books = new ArrayList<Book>();
        loadBooksFromFile(); // 启动时自动加载数据
    }

    public boolean add(Book book){
        if (!book.isValidISBN()) {
            System.out.println("错误：ISBN格式无效");
            return false;
        }
        
        if (!book.isValidCount()) {
            System.out.println("错误：库存数量不能为负数");
            return false;
        }
        
        // 检查ISBN是否已存在
        for (Book existingBook : books) {
            if (existingBook.getBookISBN().equals(book.getBookISBN())) {
                System.out.println("错误：ISBN " + book.getBookISBN() + " 已存在");
                return false;
            }
        }
        
        this.books.add(book);
        saveBooksToFile(); // 自动保存
        System.out.println("✓ 图书添加成功: " + book.getBookName());
        return true;
    }

    public int size(){
        return this.books.size();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("图书馆暂无图书");
            return;
        }
        books.sort(Comparator.comparing(Book::getBookISBN));
        
        System.out.println("\n所有图书信息（按ISBN升序）");
        System.out.println("=".repeat(80));
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%2d. %s\n", i + 1, books.get(i));
        }
        System.out.println("=".repeat(80));
        System.out.printf("总计: %d 本图书\n", books.size());
    }
    
    // 借书功能
    public boolean borrowBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            System.out.println("图书不存在，ISBN: " + isbn);
            return false;
        }
        
        if (book.borrowBook()) {
            saveBooksToFile();
            System.out.println("借书成功: " + book.getBookName());
            return true;
        } else {
            System.out.println("库存不足，无法借书: " + book.getBookName());
            return false;
        }
    }
    
    // 还书功能
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book == null) {
            System.out.println("图书不存在，ISBN: " + isbn);
            return false;
        }
        
        book.returnBook();
        saveBooksToFile();
        System.out.println("还书成功: " + book.getBookName());
        return true;
    }
    
    // 根据ISBN查找图书
    private Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getBookISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter("src/javaProgramming/demo31/book.txt")) {
            for (Book book : books) {
                writer.printf("%s,%s,%s,%d%n",
                    book.getBookISBN(), 
                    book.getBookName(), 
                    book.getBookAuthor(), 
                    book.getCount());
            }
            System.out.println("图书数据已保存到文本文件: books.txt");
        } catch (IOException e) {
            System.out.println("保存文件失败: " + e.getMessage());
        }
    }
    
    // 从文件加载图书数据（替换为文本格式）
    private void loadBooksFromFile() {
        File file = new File("src/javaProgramming/demo31/book.txt");
        if (!file.exists()) {
            System.out.println("文本数据文件不存在");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("src/javaProgramming/demo31/book.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    Book book = new Book(parts[1], parts[2], parts[0], Integer.parseInt(parts[3]));
                    books.add(book);
                }
            }
            System.out.println("从文本文件加载图书数据成功，共 " + books.size() + " 本图书");
        } catch (IOException e) {
            System.out.println("加载文件失败: " + e.getMessage());
            books = new ArrayList<>(); // 如果加载失败，创建新的空列表
        }
    }
    
    // 获取所有图书（用于测试）
    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}