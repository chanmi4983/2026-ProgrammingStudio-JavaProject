import java.io.*;

public class FileInputStreamEx {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("output1.txt");

            int one;
            while ((one = fis.read()) != -1) {
                System.out.print((char) one);
            }

            System.out.println("데이터 로딩완료!");
            fis.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}