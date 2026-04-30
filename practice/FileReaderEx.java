import java.io.*;

public class FileReaderEx {

    public static void main(String[] args) {
        try {
            FileReaderEx reader = new FileReaderEx("output2.txt");

            int data;

            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            reader.close();

            System.out.println("학생 정보 가져오기 완료!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}