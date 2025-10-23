public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Ryan", "Ali", "OUP", 2020, "12345");
        b1.setAccessionNum(1001);

        LibMember m1 = new LibMember("Ahmed", "Hassan", 'M', 123456789L, "333-4444");

        LibrarySystem lib = new LibrarySystem();

        lib.addBook(b1);
        lib.addMember(m1);

        System.out.println("Books in system: " + lib.sizeBooksList());
        System.out.println("Members in system: " + lib.sizeMembersList());

        System.out.println(b1);
        System.out.println(m1);
    }
}
