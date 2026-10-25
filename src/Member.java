import java.util.ArrayList;
import java.util.List;

class Member{

    private final int id;

    private final String name;

    private final List<Book> borrowedBooks = new ArrayList<>();


    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return List.copyOf(borrowedBooks);
    }

    public void addBorrowedBook(Book book){
//        TODO: add book to borrowedBooks if available limit = 5
    }

    public void removeBorrowedBook(Book book){
//        TODO: remove book from borrowedBooks
    }

    @Override
    public boolean equals(Object obj) {
//        TODO: ovverride for current class
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
//        TODO: override for current class
        return super.hashCode();
    }
}