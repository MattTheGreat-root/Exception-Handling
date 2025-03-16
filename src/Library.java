import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) throws InvalidBookException{
        if (book == null) {
            throw new InvalidBookException("Book should not be null");
        }
        else books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty, no books to borrow");
        }
        else {
            if (findBook(title) == null) {
                throw new BookNotFoundException("Book with title " + title + " not found");
            }
            else {
                System.out.println("Successfully Borrowed book " + findBook(title));
            }
        }
    }

    public void returnBook(String title) throws BookNotFoundException {
        if (findBook(title) == null) {
            throw new BookNotFoundException("Cannot return. Book with title " + title + " not found");
        }
        else {
            System.out.println("Successfully Returned book " + findBook(title));
        }
    }

    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty");
        }
        else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
