package com.library;

import com.library.exceptions.BookNotAvailableException;
import com.library.exceptions.BorrowLimitExceededException;
import com.library.exceptions.MemberNotFoundException;

public class LibraryController {

    private static final Library library = new Library();

    private static int lastBookID = 0;

    private static int lastMemberID = 0;

    public void addBook(String name, String author){
        library.addBook(new Book(lastBookID++, name, author));
    }

    public void addMember(String name){
        library.regMember(new Member(lastMemberID++, name));
    }

    public void borrowBook(int memberID, int bookID) throws BookNotAvailableException, MemberNotFoundException, BorrowLimitExceededException {
        library.borrow(memberID, bookID);
    }

    public void returnBook(int memberID, int bookID) throws BookNotAvailableException, MemberNotFoundException {
        library.returnBook(memberID, bookID);
    }

}
