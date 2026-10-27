package com.library;

public class Book{
    private final int bookID;

    private final String name;

    private final String author;

    private boolean isAvailable;

    public Book(int bookID, String name, String author) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.isAvailable = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        var anotherBook = (Book) obj;
        return bookID == anotherBook.bookID &&
                name.equals(anotherBook.name) &&
                author.equals(anotherBook.author) &&
                isAvailable == anotherBook.isAvailable();
    }

    @Override
    public int hashCode() {
        return 31 * bookID * name.hashCode() * author.hashCode();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getBookID() {
        return bookID;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailable(boolean status) {
        if (isAvailable == status) throw new IllegalArgumentException(String.format("com.library.Book is %s available. Changes is not need", isAvailable ? "" : "not") );
        isAvailable = status;
    }
}