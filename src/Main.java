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
            System.out.println("8. Filter by Category");
            System.out.println("9. Recommend Book"); 
            System.out.println("10. Add Test Data");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Select menu: ");

            int menu = s.nextInt();

            if (menu == 1) {
                manager.addBook();
                System.out.println();
            } 
            
            else if (menu == 2) {
                manager.listBooks();
                System.out.println();
            } 
            
            else if (menu == 3) {
                manager.updateBook();
                System.out.println();
            } 
            else if (menu == 4) {
                manager.deleteBook();
            }else if (menu == 5) {
                manager.saveBooks();
            }else if (menu == 6) {
                manager.loadBooks();
            }else if (menu == 7) {
                manager.searchBook();
            }else if (menu == 8) {
                manager.filterByCategory();
            }else if (menu == 9) {
                manager.recommendBook();
            }
            else if (menu == 10) {
                System.out.println("테스트 데이터");
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