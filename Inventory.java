import java.util.ArrayList;

public class Inventory {

    private ArrayList<Book> mainInventory;
    private ArrayList<Book> borrowedBooks;

    public Inventory() {

        mainInventory = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {

        mainInventory.add(book);
        System.out.println("Book added to the library.");
    }

    // Borrow Book
    public void borrowBook(int id) {

        for (Book book : mainInventory) {

            if (book.getId() == id) {

                borrowedBooks.add(book);
                mainInventory.remove(book);

                System.out.println(
                        "Book successfully borrowed.");
                return;
            }
        }

        System.out.println(
                "Book not found or already borrowed.");
    }

    // Return Book
    public void returnBook(int id) {

        for (Book book : borrowedBooks) {

            if (book.getId() == id) {

                mainInventory.add(book);
                borrowedBooks.remove(book);

                System.out.println(
                        "Book successfully returned.");
                return;
            }
        }

        System.out.println(
                "Book is not currently borrowed.");
    }

    // Print All Books
    public void printAll() {

        if (mainInventory.isEmpty()) {

            System.out.println("No books available.");
            return;
        }

        for (Book book : mainInventory) {

            book.printBookInfo();
        }
    }

    // Search by Title
    public void searchByTitle(String title) {

        boolean found = false;

        for (Book book : mainInventory) {

            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {

                book.printBookInfo();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No matching book found.");
        }
    }
}