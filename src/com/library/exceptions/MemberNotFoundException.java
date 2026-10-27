package com.library.exceptions;

public class MemberNotFoundException extends Exception {

    private final int memberID;


    public MemberNotFoundException(int memberID) {
        this.memberID = memberID;
    }

    @Override
    public String getMessage() {
//        TODO: override message
        return String.format("com.library.Member with ID %d does not exist", memberID);
    }

    public int getMemberID() {
        return memberID;
    }
}