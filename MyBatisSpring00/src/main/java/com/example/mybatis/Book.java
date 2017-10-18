package com.example.mybatis;

public class Book {
    private Integer bookId;
    private String bookName;
    private String author;
    private Integer price;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String author, Integer price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
            "bookId=" + bookId +
            ", bookName='" + bookName + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
