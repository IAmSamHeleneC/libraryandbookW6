public class Library {
    // Add the missing implementation to this class
    String libraryAddress;
    Book[] Books = new Book[0];

    // Create Library
    public Library(String address) {
        libraryAddress = address;
    }

    // Add book
    public void addBook(Book text) {
        int len = Books.length;
        Book[] temp = new Book[len + 1];
        for (int i = 0; i < len; i++) {
            temp[i] = Books[i];
        }
        temp[len] = text;
        Books = new Book[temp.length];
        for (int i = 0; i < Books.length; i++) {
            Books[i] = temp[i];
        }
    }

    // Return book
    public void returnBook(String returningBook) {
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getTitle().compareTo(returningBook) == 0) {
                if (Books[i].isBorrowed()) {
                    Books[i].returned();
                    System.out.println("You successfully returned " + returningBook);
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not from our library.");
    }

    // Print available books
    public void printAvailableBooks() {
        for (int i = 0; i < Books.length; i++) {
            if (!Books[i].isBorrowed()) {
                System.out.println(Books[i].getTitle());
            }
        }
        if (Books.length == 0) {
            System.out.println("Nothing in the library.");
        }
    }

    // Borrow book
    public void borrowBook(String requestedBook) {
        for (int i = 0; i < Books.length; i++) {
            if (Books[i].getTitle().compareTo(requestedBook) == 0) {
                if (Books[i].isBorrowed()) {
                    System.out.println("Sorry, the book is already borrowed.");
                    return;
                } else {
                    Books[i].borrow();
                    System.out.println("You successfully borrowed " + requestedBook);
                    return;
                }
            }
        }
        System.out.println("Sorry, the book is not in our library");
    }
    

    // Print Hours
    public static void printOpeningHours() {
        System.out.println("9am - 5pm, Monday through Saturday");
    }

    // Print address
    public void printAddress() {
        System.out.println(this.libraryAddress);
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
