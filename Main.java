import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                }
                case 2 -> {
                    System.out.print("Enter title of book to remove: ");
                    String title = scanner.nextLine();
                    library.removeBook(title);
                }
                case 3 -> library.listBooks();
                case 4 -> {
                    System.out.print("Enter title of book to borrow: ");
                    String title = scanner.nextLine();
                    Book bookToBorrow = library.findBook(title);
                    if (bookToBorrow != null) {
                        bookToBorrow.borrowBook();
                    }
                }
                case 5 -> {
                    System.out.print("Enter title of book to return: ");
                    String title = scanner.nextLine();
                    Book bookToReturn = library.findBook(title);
                    if (bookToReturn != null) {
                        bookToReturn.returnBook();
                    }
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
