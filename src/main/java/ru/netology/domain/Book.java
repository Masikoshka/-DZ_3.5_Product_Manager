package ru.netology.domain;

public class Book extends Product{
    private String author;

    public Book() {
        super();
    }

    public Book(String name, int id, int price, String author) {
        super(name, id, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
