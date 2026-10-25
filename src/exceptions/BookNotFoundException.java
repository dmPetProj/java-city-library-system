package exceptions;

class BookNotFoundException extends BookNotAvailableException {

    BookNotFoundException(int bookID) {
        super(bookID);
    }

    @Override
    public String getMessage() {
//        TODO: override message
        return "";
    }
}