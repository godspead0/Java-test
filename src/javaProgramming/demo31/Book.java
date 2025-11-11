package javaProgramming.demo31;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String bookName;
    private String bookAuthor;
    private String bookISBN;
    private int count;
    
    public Book(String bookName, String bookAuthor, String bookISBN, int count) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookISBN = bookISBN;
        this.count = count;
    }
    
    // Getter方法
    public String getBookName() {
        return bookName;
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public String getBookISBN() {
        return bookISBN;
    }
    
    public int getCount() {
        return count;
    }
    
    // 借书方法
    public boolean borrowBook() {
        if (count > 0) {
            count--;
            return true;
        }
        return false;
    }
    
    // 还书方法
    public void returnBook() {
        count++;
    }

    public String toString() {
        return String.format("ISBN: %s | 书名: %s | 作者: %s | 库存: %d", 
                           bookISBN, bookName, bookAuthor, count);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(bookISBN, book.bookISBN);
    }

    public int hashCode() {
        return Objects.hash(bookISBN);
    }
    
    // 验证ISBN格式（简单验证）
    public boolean isValidISBN() {
        return bookISBN != null && !bookISBN.trim().isEmpty();
    }
    
    // 验证库存是否有效
    public boolean isValidCount() {
        return count >= 0;
    }
}