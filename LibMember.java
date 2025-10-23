public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued = new Book[10];
    private int numBooksIssued = 0;

    public LibMember() {
        this.firstName = "";
        this.lastName = "";
        this.gender = 'U';
        this.cprNum = 0L;
        this.teleNum = "";
        this.booksIssued = new Book[10];
        this.numBooksIssued = 0;
    }

    public LibMember(String firstName, String lastName, char gender, long cprNum, String teleNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cprNum;
        this.teleNum = teleNum;
        this.booksIssued = new Book[10];
        this.numBooksIssued = 0;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public long getCprNum() { return cprNum; }
    public void setCprNum(long cprNum) { this.cprNum = cprNum; }

    public String getTeleNum() { return teleNum; }
    public void setTeleNum(String teleNum) { this.teleNum = teleNum; }

    public Book[] getBooksIssued() { return booksIssued; }
    public void setBooksIssued(Book[] booksIssued) { this.booksIssued = booksIssued; }

    public int getNumBooksIssued() { return numBooksIssued; }
    public void setNumBooksIssued(int numBooksIssued) { this.numBooksIssued = numBooksIssued; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibMember member = (LibMember) obj;
        return cprNum == member.cprNum;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
               " | CPR: " + cprNum +
               " | Books issued: " + numBooksIssued;
    }
}
