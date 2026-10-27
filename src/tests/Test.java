package tests;

import com.library.Library;
import com.library.Book;
import com.library.Member;

public class Test {

    public static int pass = 0;
    public static int fail = 0;

    public static void main(String[] args) {
        allTest();
    }

    public static void allTest(){
        addBook();
        addMemer();
        takeBook();
        takeBorrowedBook();
        takeBookNotAddedMember();
        takeUnknownBook();
        returnBook();
        returnUnknownBook();
        returnNotBorrowedBook();

        System.out.printf("Count test: %d\n", pass+fail);
        System.out.printf("Test pass: %d\n", pass);
        System.out.printf("Test fail: %d\n", fail);
    }

    public static void addBook() {
        try {
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail++;
            return;
        }
        pass++;
    }

    public static void addMemer(){
        try{
            var library = new Library();
            library.regMember(new Member(1, "Make"));
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail++;
            return;
        }
        pass++;
    }

    public static void takeBook(){
        try {
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
            library.regMember(new Member(1, "Make"));
            library.borrow(1,1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail++;
            return;
        }
        pass++;
    }

    public static void takeBorrowedBook(){
        try {
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
            library.regMember(new Member(1, "Make"));
            library.regMember(new Member(3, "Lanser"));
            library.borrow(1,1);
            library.borrow(3,1);
        } catch (Exception e) {
            pass++;
            return;
        }
        fail++;
    }

    public static void takeBookNotAddedMember(){
        try {
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
            library.borrow(1,1);
        } catch (Exception e) {
            pass++;
            return;
        }
        fail++;
    }

    public static void takeUnknownBook(){
        try {
            var library = new Library();
            library.regMember(new Member(999, "Gaster"));
            library.returnBook(999,1);
        } catch (Exception e) {
            pass++;
            return;
        }
        fail++;
    }

    public static void returnBook() {
        try {
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
            library.regMember(new Member(1, "Make"));
            library.borrow(1,1);
            library.returnBook(1,1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail++;
            return;
        }
        pass++;
    }

    public static void returnUnknownBook(){
        try{
            var library = new Library();
            library.regMember(new Member(1, "Make"));
            library.returnBook(1,1);
        } catch (Exception e) {
            pass++;
            return;
        }
        fail++;
    }

    public static void returnNotBorrowedBook() {
        try{
            var library = new Library();
            library.addBook(new Book(1, "A", "AA"));
            library.regMember(new Member(1, "Make"));
            library.returnBook(1,1);
        } catch (Exception e) {
            pass++;
            return;
        }
        fail++;
    }
}
