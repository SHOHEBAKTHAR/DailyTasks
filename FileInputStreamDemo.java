import java.io.*;
public class FileInputStreamDemo{
public static void main(String args[]) throws IOException{
FileInputStream fis =new FileInputStream("file1.txt");
BufferedInputStream bis=new BufferedInputStream(fis);
int size=bis.available();
byte[] buffer=new byte[size];
bis.read(buffer);
String s=new String(buffer);
System.out.print(s);
bis.close();
fis.close();
}
}
