package exceptions;

public class BookNotFoundException extends BookNotAvailableException {

    public BookNotFoundException(int bookID) {
        super(bookID);
    }

    @Override
    public String getMessage() {
//        TODO: override message
        return "";
    }
}