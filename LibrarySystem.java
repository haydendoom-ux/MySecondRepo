import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Inventory inventory = new Inventory();

        int choice = 0;

        do {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");

            try {

                System.out.print("Enter choice: ");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Title: ");
                        String title = input.nextLine();

                        System.out.print("Enter Author: ");
                        String author = input.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = input.nextLine();

                        System.out.print("Enter Pages: ");
                        int pages = input.nextInt();

                        Book book =
                                new Book(id, title,
                                        author, isbn, pages);

                        inventory.addBook(book);
                        break;

                    case 2:

                        System.out.print(
                                "Enter Book ID to borrow: ");

                        int borrowId =
                                input.nextInt();

                        inventory.borrowBook(
                                borrowId);
                        break;

                    case 3:

                        System.out.print(
                                "Enter Book ID to return: ");

                        int returnId =
                                input.nextInt();

                        inventory.returnBook(
                                returnId);
                        break;

                    case 4:

                        input.nextLine();

                        System.out.print(
                                "Enter title to search: ");

                        String searchTitle =
                                input.nextLine();

                        inventory.searchByTitle(
                                searchTitle);
                        break;

                    case 5:

                        inventory.printAll();
                        break;

                    case 6:

                        System.out.println(
                                "Exiting the program. Goodbye!");
                        break;

                    default:

                        System.out.println(
                                "Invalid option.");
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid input. Try again.");

                input.nextLine();
            }

        } while (choice != 6);

        input.close();
    }
}