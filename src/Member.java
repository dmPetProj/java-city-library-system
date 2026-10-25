import exceptions.BookNotAvailableException;
import exceptions.BorrowLimitExceededException;

import java.util.ArrayList;
import java.util.List;

class Member{

    private final int id;

    private final String name;

    private final List<Book> borrowedBooks = new ArrayList<>();


    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return List.copyOf(borrowedBooks);
    }

    public void addBorrowedBook(Book book) throws BookNotAvailableException, BorrowLimitExceededException {
        if (!book.isAvailable())
            throw new BookNotAvailableException(book.getBookID());
        if (borrowedBooks.size() > 5)
            throw new BorrowLimitExceededException(id, 5);
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book){
        var ind = borrowedBooks.indexOf(book);
        if (ind == -1)
            throw new  IllegalArgumentException(String.format("Member with id %d didnt get book with id %d", id, book.getBookID()));
        borrowedBooks.remove(ind);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        var memb = (Member) obj;
        return id == memb.id &&
                name.equals(memb.name);
    }

    @Override
    public int hashCode() {
        return 31 * id * name.hashCode() * borrowedBooks.hashCode();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}