import java.io.*;

public class FileOutputStreamEx {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("output1.txt");

            fos.write('A');      // 문자
            fos.write(65);       // ASCII
            fos.write('\n');     // 줄바꿈

            System.out.println("AA 저장됨!!");

            String str = "Hello Word!!";
            fos.write(str.getBytes());  // 문자열 → byte 배열

            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}