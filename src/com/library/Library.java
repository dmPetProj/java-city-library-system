package com.library;

import com.library.exceptions.BookNotAvailableException;
import com.library.exceptions.BookNotFoundException;
import com.library.exceptions.BorrowLimitExceededException;
import com.library.exceptions.MemberNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<Integer, Book> bookByID = new HashMap<>();

    private final Map<Integer, Member> memberByID = new HashMap<>();

    private void validateById(int memberID, int bookID) throws MemberNotFoundException, BookNotFoundException {
        if (!memberByID.containsKey(memberID))
            throw new MemberNotFoundException(memberID);
        if (!bookByID.containsKey(bookID))
            throw new BookNotFoundException(bookID);
    }

    public void addBook(Book book){
        if (bookByID.containsKey(book.getBookID()))
            throw new IllegalArgumentException(String.format("Book with id %d is already added", book.getBookID()));
        bookByID.put(book.getBookID(), book);
    }

    public void regMember(Member member){
        if (memberByID.containsKey(member.getId()))
            throw new IllegalArgumentException(String.format("Member with id %d is already added", member.getId()));
        memberByID.put(member.getId(), member);
    }

    public void borrow(int memberID, int bookID) throws MemberNotFoundException, BookNotAvailableException, BorrowLimitExceededException {
        validateById(memberID, bookID);
        var member = memberByID.get(memberID);
        var book = bookByID.get(bookID);
        if (!book.isAvailable())
            throw new BookNotAvailableException(book.getBookID());
        member.addBorrowedBook(book);
        book.setAvailable(false);

    }

    public void returnBook(int memberID, int bookID) throws MemberNotFoundException, BookNotAvailableException {
        validateById(memberID, bookID);
        var member = memberByID.get(memberID);
        var book = bookByID.get(bookID);
        if (book.isAvailable())
            throw new BookNotAvailableException(book.getBookID());
        member.removeBorrowedBook(book);
        book.setAvailable(true);
    }
}