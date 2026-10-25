class Book{

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
        // TODO: override to current class
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
        // TODO: override to current class
        return 31 * bookID * name.hashCode() * auter.hashCode();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        // TODO: validate and set
        if (isAvailable == status) throw new IllegalArgumentException(String.format("Book is %s available. Changes is not need", isAvailable ? "" : "not") );
        isAvailable = status;
    }
}