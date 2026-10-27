package com.library.exceptions;

public class BookNotFoundException extends BookNotAvailableException {

    public BookNotFoundException(int bookID) {
        super(bookID);
    }

    @Override
    public String getMessage() {
        return String.format("com.library.Book with ID %d does not exist", getBookID());
    }
}