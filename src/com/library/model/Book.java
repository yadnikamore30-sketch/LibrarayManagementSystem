package com.library.model;

public class Book {

    private int book_id;
    private String title;
    private String author;
    private int publisher_id;
    private String category;
    private int quantity;

    public Book(int book_id, String title, String author, int publisher_id, String category, int quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publisher_id = publisher_id;
        this.category = category;
        this.quantity = quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher_id=" + publisher_id +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


