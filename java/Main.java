import java.util.ArrayList;


class Book {
    private String title;
    private String author;
    private String isbn;

    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }


    public void displayBook() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
        System.out.println("-------------------------");
    }
}


class Library {
    private ArrayList<Book> books = new ArrayList<>();

    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    
    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nBooks in Library:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        
        library.addBook(new Book("Java Programming", "James Gosling", "1111"));
        library.addBook(new Book("Data Structures", "Mark Allen Weiss", "2222"));
        library.addBook(new Book("Operating Systems", "Galvin", "3333"));

        
        library.displayAllBooks();

        System.out.println("\nSearching for 'Data Structures'...");
        Book found = library.searchByTitle("Data Structures");

        if (found != null) {
            System.out.println("Book Found:");
            found.displayBook();
        } else {
            System.out.println("Book not found.");
        }
    }
}

