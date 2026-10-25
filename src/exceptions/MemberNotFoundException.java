package exceptions;

class MemberNotFoundException extends Exception {

    private final int memberID;


    MemberNotFoundException(int memberID) {
        this.memberID = memberID;
    }

    @Override
    public String getMessage() {
//        TODO: override message
        return super.getMessage();
    }

    public int getMemberID() {
        return memberID;
    }
}