import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "[" + bookId + ", " + title + ", " + author + "]";
    }
}

public class LibraryManagementSystem {
    Book[] books;

    public LibraryManagementSystem(Book[] books) {
        this.books = Arrays.copyOf(books, books.length);
    }

    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearch(String title) {
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0;
        int right = sortedBooks.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedBooks[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return sortedBooks[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Wings of Fire", "A.P.J. Abdul Kalam"),
            new Book(3, "Harry Potter", "J.K. Rowling"),
            new Book(4, "Clean Code", "Robert C. Martin")
        };

        LibraryManagementSystem lms = new LibraryManagementSystem(books);

        System.out.println("Linear Search for 'Harry Potter':");
        Book result1 = lms.linearSearch("Harry Potter");
        System.out.println(result1);

        System.out.println("\nBinary Search for 'Harry Potter':");
        Book result2 = lms.binarySearch("Harry Potter");
        System.out.println(result2);
    }
}
