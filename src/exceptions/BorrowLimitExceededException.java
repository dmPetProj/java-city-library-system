package exceptions;

public class BorrowLimitExceededException extends Exception {

    private final int memberID;

    private final int limit;


    public BorrowLimitExceededException(int memberID, int limit) {
        this.memberID = memberID;
        this.limit = limit;
    }

    @Override
    public String getMessage() {
//        TODO: override message
        return super.getMessage();
    }

    public int getLimit() {
        return limit;
    }

    public int getMemberID() {
        return memberID;
    }
}