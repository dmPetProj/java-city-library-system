import java.util.HashMap;
import java.util.Map;

class Library {

    private final Map<Integer, Book> bookByID = new HashMap<>();

    private final Map<Integer, Member> memberByID = new HashMap<>();

    public void addBook(Book book){
        if (!bookByID.containsKey(book.getBookID()))
            bookByID.put(book.getBookID(), book);
    }

    public void regMember(Member member){

    }

    public void borrow(int memberID, int bookID){
//        TODO: validate if memID bookID contains give book to member
    }

    public void returnBook(int memberID, int bookID){
//        TODO: validate if memID bookID contains return book to library
    }
}