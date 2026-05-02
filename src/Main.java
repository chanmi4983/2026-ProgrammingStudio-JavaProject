import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BookManager manager = new BookManager();



        while (true) {
            System.out.println("\n===== Book Management Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Save Book");
            System.out.println("6. Load Book");
            System.out.println("7. Search Book");
            System.out.println("9. addTest Book"); //입력 매번하기 힘들어서 임시 데이터 추가
            System.out.println("0. Exit");
            System.out.print("Select menu: ");

            int menu = s.nextInt();

            if (menu == 1) {
                manager.addBook();
            } 
            
            else if (menu == 2) {
                manager.listBooks();
            } 
            
            else if (menu == 3) {
                manager.updateBook();
            } 
            else if (menu == 4) {
                manager.deleteBook();
            }else if (menu == 5) {
                manager.saveBooks();
            }else if (menu == 6) {
                manager.loadBooks();
            }else if (menu == 7) {
                manager.searchBook();
            }else if (menu == 9) {
                System.out.println("기존의 책들");
                manager.addTestData();
            }
             else if (menu == 0) {
                System.out.println("Program exited.");
                break;
            } else {
                System.out.println("Invalid menu.");
            }
        }
    }
}