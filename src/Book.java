class Book{
    //        TODO: make getter to book id, autor name
    private final int bookID;

    private final String name;

    private final String auter;

    private boolean isAvailable;

    Book(int bookID, String name, String auter) {
        this.bookID = bookID;
        this.name = name;
        this.auter = auter;
        this.isAvailable = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        var anotherBook = (Book) obj;
        return bookID == anotherBook.bookID &&
                name.equals(anotherBook.name) &&
                auter.equals(anotherBook.auter) &&
                isAvailable == anotherBook.isAvailable();
    }

    @Override
    public int hashCode() {
        return 31 * bookID * name.hashCode() * auter.hashCode();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        if (isAvailable == status) throw new IllegalArgumentException(String.format("Book is %s available. Changes is not need", isAvailable ? "" : "not") );
        isAvailable = status;
    }
}