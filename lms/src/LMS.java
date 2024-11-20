public class LMS {
    public static void main(String[] args) {
        Library library = getLibrary();

        library.borrowBook("M001", "123-456-789");
        library.borrowBook("M001", "987-654-321");
        library.borrowBook("M002", "456-789-123");

        System.out.println("Available books: " + library.getAvailableBooks());

        System.out.println("Books borrowed by Bruce: " + library.getBorrowedBooksByMember("M001"));
        System.out.println("Books borrowed by Jeremy: " + library.getBorrowedBooksByMember("M002"));

        library.returnBook("M001", "987-654-321");

        System.out.println("Available books after return: " + library.getAvailableBooks());
    }

    private static Library getLibrary() {
        Library library = new Library();

        Book book1 = new Book("123-456-789", "Rich Dad Poor Dad", "Robert Kiyosaki", 2000);
        Book book2 = new Book("987-654-321", "Introduction to Hibernate", "Larissa", 2005);
        Book book3 = new Book("456-789-123", "Introduction to Algorithms", "Jean Damascene", 1990);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Member member1 = new Member("M001", "Bruce");
        Member member2 = new Member("M002", "Jeremy");
        library.addMember(member1);
        library.addMember(member2);

        return library;
    }
}