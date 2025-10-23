import java.util.LinkedList;
import java.util.Iterator;

public class LibrarySystem {
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    public LibrarySystem() {
        booksList = new LinkedList<>();
        membersList = new LinkedList<>();
        booksListSize = 0;
        membersListSize = 0;
    }

    public boolean addBook(Book book) {
        if (book == null) return false;
        if (booksList.contains(book)) return false;
        booksList.add(book);
        booksListSize++;
        return true;
    }

    public boolean deleteBook(long accessionNum) {
        Iterator<Book> it = booksList.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getAccessionNum() == accessionNum) {
                if (book.getIssuedTo() != null) return false;
                it.remove();
                booksListSize--;
                return true;
            }
        }
        return false;
    }

    public boolean addMember(LibMember member) {
        if (member == null) return false;
        if (membersList.contains(member)) return false; // fix
        membersList.add(member);
        membersListSize++;
        return true;
    }

    public boolean deleteMember(long cprNum) {
        Iterator<LibMember> it = membersList.iterator();
        while (it.hasNext()) {
            LibMember member = it.next();
            if (member.getCprNum() == cprNum) {
                if (member.getNumBooksIssued() > 0) return false;
                it.remove();
                membersListSize--;
                return true;
            }
        }
        return false;
    }

    public int searchBook(long accessionNum) {
        int number = 0;
        for (Book book : booksList) {
            if (book.getAccessionNum() == accessionNum) return number;
            number++;
        }
        return -1;
    }

    public int searchMember(long cprNum) {
        int number = 0;
        for (LibMember member : membersList) {
            if (member.getCprNum() == cprNum) return number;
            number++;
        }
        return -1;
    }

    public boolean isEmptyBooksList() { return booksList.isEmpty(); }
    public boolean isEmptyMembersList() { return membersList.isEmpty(); }
    public int sizeBooksList() { return booksListSize; }
    public int sizeMembersList() { return membersListSize; }
}
