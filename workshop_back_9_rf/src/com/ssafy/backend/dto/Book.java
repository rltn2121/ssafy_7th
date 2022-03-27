package com.ssafy.backend.dto;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String desc;
    private String img;

    public Book() {}

    public Book(String isbn, String title, String author, int price, String desc, String img) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.desc = desc;
        this.img = img;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "[" + (isbn != null ? "isbn=" + isbn + ", " : "") + (title != null ? "title=" + title + ", " : "") + (author != null ? "author=" + author + ", " : "") + "price=" + price + ", " + (desc != null ? "desc=" + desc + ", " : "") + (img != null ? "img=" + img : "") + "]";
    }


}
