package exceptions;

class BookNotAvailableException extends Exception {

    private final int bookID;


    BookNotAvailableException(int bookID) {
        this.bookID = bookID;
    }


    public int getBookID() {
        return bookID;
    }

    @Override
    public String getMessage() {
//        TODO: make message
        return "";
    }
}