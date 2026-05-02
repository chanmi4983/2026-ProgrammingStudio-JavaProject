import java.util.ArrayList;
import java.util.Scanner;
//로드용
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BookManager implements ICRUD {
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

    public void saveBooks() { //책 저장하기 
    try {
        PrintWriter pw = new PrintWriter(new FileWriter("books.txt"));

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            pw.println(
                book.getId() + "," +
                book.getTitle() + "," +
                book.getAuthor() + "," +
                book.getPublisher() + "," +
                book.getCategory() + "," +
                book.getStatus() + "," +
                book.getRating()
            );
        }

        pw.close();
        System.out.println("Books saved successfully.");

    } catch (IOException e) {
        System.out.println("Error saving file.");
    }
}
    public void loadBooks() {
    try {
        File file = new File("books.txt");
        Scanner fileScanner = new Scanner(file);

        books.clear();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] data = line.split(",");

            if (data.length == 7) {
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                String publisher = data[3];
                String category = data[4];
                String status = data[5];
                int rating = Integer.parseInt(data[6]);

                Book book = new Book(id, title, author, publisher, category, status, rating);
                books.add(book);
            }
        }

        fileScanner.close();
        System.out.println("Load File");

    } catch (FileNotFoundException e) {
        System.out.println("저장된 파일이 없습니다.");
        }
    }

    public void addTestData() {
    books.add(new Book(1, "Java", "Kim", "Hanbit", "Programming", "읽는중", 5));
    books.add(new Book(2, "OS", "Lee", "Pearson", "CS", "완료", 4));
    books.add(new Book(3, "Network", "Park", "McGraw", "CS", "미완료", 3));
    books.add(new Book(4, "DB", "Choi", "Oracle", "CS", "읽는중", 5));
    books.add(new Book(5, "AI", "Jung", "Springer", "AI", "미완료", 4));

    System.out.println("테스트 데이터 추가됨");
    }




}