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


    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i); //리스트에서 i번째 책 하나 꺼냄 ArrayList.get() 메소드 사용
            System.out.println(book);
        }
    }

    public void updateBook() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            if (book.getId() == id) {
                System.out.print("New Title: ");
                book.setTitle(sc.nextLine());

                System.out.print("New Author: ");
                book.setAuthor(sc.nextLine());

                System.out.print("New Publisher: ");
                book.setPublisher(sc.nextLine());

                System.out.print("New Category: ");
                book.setCategory(sc.nextLine());

                System.out.print("New Status: ");
                book.setStatus(sc.nextLine());

                System.out.print("New Rating: ");
                book.setRating(sc.nextInt());
                sc.nextLine();

                System.out.println("Book updated successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }


}