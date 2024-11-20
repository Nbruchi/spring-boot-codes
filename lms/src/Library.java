import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(books);
        for (Member member : members) {
            availableBooks.removeAll(member.getBorrowedBooks());
        }
        return availableBooks;
    }

    public void borrowBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member != null && book != null && getAvailableBooks().contains(book)) {
            member.borrowBook(book);
        }
    }

    public void returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member != null && book != null) {
            member.returnBook(book);
        }
    }

    public List<Book> getBorrowedBooksByMember(String memberId) {
        Member member = findMemberById(memberId);
        return member != null ? member.getBorrowedBooks() : new ArrayList<>();
    }
    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
