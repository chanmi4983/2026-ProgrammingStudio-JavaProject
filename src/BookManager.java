import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books;
    private Scanner sc;

    public BookManager() {
        books = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Publisher: ");
        String publisher = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("Rating: ");
        int rating = sc.nextInt();
        sc.nextLine();

        Book book = new Book(id, title, author, publisher, category, status, rating);
        books.add(book);

        System.out.println("Book added successfully.");
    }
}