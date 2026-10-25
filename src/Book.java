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
        return false;
    }

    @Override
    public int hashCode() {
        // TODO: override to current class
        return super.hashCode();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        // TODO: validate and set
    }
}