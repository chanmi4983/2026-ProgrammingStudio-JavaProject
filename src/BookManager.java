import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books;
    private Scanner s;

    public BookManager() {
        books = new ArrayList<>();
        s = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("Title: ");
        String title = s.nextLine();

        System.out.print("Author: ");
        String author = s.nextLine();

        System.out.print("Publisher: ");
        String publisher = s.nextLine();

        System.out.print("Category: ");
        String category = s.nextLine();

        System.out.print("Status: ");
        String status = s.nextLine();

        System.out.print("Rating: ");
        int rating = s.nextInt();
        s.nextLine();

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
        int id = s.nextInt();
        s.nextLine();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            if (book.getId() == id) {
                System.out.print("New Title: ");
                book.setTitle(s.nextLine());

                System.out.print("New Author: ");
                book.setAuthor(s.nextLine());

                System.out.print("New Publisher: ");
                book.setPublisher(s.nextLine());

                System.out.print("New Category: ");
                book.setCategory(s.nextLine());

                System.out.print("New Status: ");
                book.setStatus(s.nextLine());

                System.out.print("New Rating: ");
                book.setRating(s.nextInt());
                s.nextLine();

                System.out.println("Book updated successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void deleteBook() {
        System.out.print("Enter ID to delete: ");
        int id = s.nextInt();
        s.nextLine(); // 남은 엔터 제거

        for (int i = 0; i < books.size(); i++) {
        if (books.get(i).getId() == id) {
            books.remove(i);
            System.out.println("Book deleted successfully.");
            return;
        }
    }
    System.out.println("Book not found.");
    
    }




}