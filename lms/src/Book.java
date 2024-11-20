public class Book {
    private final String isbn;
    private final String title;
    private final String authors;
    private final int publicationYear;

    public Book(String isbn, String title, String authors, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
