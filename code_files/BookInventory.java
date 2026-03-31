import java.util.*;

// Custom Exception for Invalid Book Data
class InvalidBookException extends Exception {
    public InvalidBookException(String message) {
        super(message);
    }
}

// Book Class
class BookInventory {

    private String title;
    private String author;
    private double price;
    private int stockCount;
    private String isbn;

    // Default Constructor
    public BookInventory() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.stockCount = 0;
        this.isbn = "N/A";
    }

    // Parameterized Constructor
    public BookInventory(String title, String author, double price,
                         int stockCount, String isbn) throws InvalidBookException {

        if (title == null || title.trim().isEmpty())
            throw new InvalidBookException("Title cannot be empty.");

        if (author == null || author.trim().isEmpty())
            throw new InvalidBookException("Author cannot be empty.");

        if (price < 0)
            throw new InvalidBookException("Price cannot be negative.");

        if (stockCount < 0)
            throw new InvalidBookException("Stock count cannot be negative.");

        if (isbn == null || isbn.length() < 5)
            throw new InvalidBookException("Invalid ISBN.");

        this.title = title;
        this.author = author;
        this.price = price;
        this.stockCount = stockCount;
        this.isbn = isbn;
    }

    // Copy Constructor
    public BookInventory(BookInventory b) {
        this.title = b.title;
        this.author = b.author;
        this.price = b.price;
        this.stockCount = b.stockCount;
        this.isbn = b.isbn;
    }

    // Method to display book details
    public void display() {
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : " + price);
        System.out.println("StockCount : " + stockCount);
        System.out.println("ISBN       : " + isbn);
        System.out.println("---------------------------");
    }
}

// Main Class
class BookStoreDemo {

    public static void main(String[] args) {

        ArrayList<BookInventory> bookList = new ArrayList<>();

        try {
            BookInventory b1 = new BookInventory(
                    "Java Programming",
                    "Herbert Schildt",
                    550.0,
                    10,
                    "ISBN001"
            );

            BookInventory b2 = new BookInventory(
                    "Python for Data Science",
                    "Jake VanderPlas",
                    650.0,
                    5,
                    "ISBN002"
            );

            BookInventory b3 = new BookInventory(b1);

            bookList.add(b1);
            bookList.add(b2);
            bookList.add(b3);

        } catch (InvalidBookException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }

        // Display all books
        System.out.println("Book Details:\n");
        for (BookInventory b : bookList) {
            b.display();
        }

        // Exception Demo (handled separately)
        try {
            BookInventory b4 = new BookInventory(
                    "Invalid Book",
                    "Test Author",
                    -200,   // Invalid price
                    3,
                    "ISBN003"
            );
            bookList.add(b4);

        } catch (InvalidBookException e) {
            System.out.println("Exception Occurred While Adding Invalid Book: " + e.getMessage());
        }
    }
}
