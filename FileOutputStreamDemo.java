import java.io.*;
public class FileOutputStreamDemo{
    public static void main(String args[]) throws IOException {
        FileOutputStream fos= new FileOutputStream("file1.txt");
        BufferedOutputStream bos= new BufferedOutputStream(fos);
        String s="Hii Shoheb";
        bos.write(s.getBytes());
        System.out.print("File Created");
        bos.close();
        fos.close();
    }
}