package com.library;

import com.library.exceptions.BookNotAvailableException;
import com.library.exceptions.BorrowLimitExceededException;
import com.library.exceptions.MemberNotFoundException;

import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);

    private final LibraryController libraryController = new LibraryController();

    private static final String[] strings = {
            "1. Add new book",
            "2. Register new member",
            "3. Give book to member",
            "4. Return book",
            "0. Exit"
    };

    public void makeMenu() {
        for (var it : strings)
            System.out.println(it);
        System.out.print("Enter number of action: ");
        int action = scanner.nextInt();
        executeAction(action);
    }

    private void executeAction(int numOfAction){
        switch ( numOfAction ) {
            case 1 -> {
                System.out.print("Enter book name and author: ");
                String bookName = scanner.nextLine(),
                        author = scanner.nextLine();
                libraryController.addBook(bookName, author);
            }
            case 2 -> {
                System.out.print("Enter member name: ");
                String memberName = scanner.nextLine();
                libraryController.addMember(memberName);
            }
            case 3 -> {
                System.out.println("Enter member ID and ID book he need: ");
                try {
                    int memberID = scanner.nextInt(),
                            bookID = scanner.nextInt();
                    libraryController.borrowBook(memberID, bookID);
                } catch (BookNotAvailableException | MemberNotFoundException | BorrowLimitExceededException
                        e) {
                    System.out.println(e.getMessage());
                }
            }
            case 4 -> {
                System.out.println("Enter member ID and ID book he return: ");
                try {
                    int memberID = scanner.nextInt(),
                            bookID = scanner.nextInt();
                    libraryController.returnBook(memberID, bookID);
                } catch (BookNotAvailableException | MemberNotFoundException
                        e) {
                    System.out.println(e.getMessage());
                }
            }
            default ->  System.exit(0);
        }
    }
}
