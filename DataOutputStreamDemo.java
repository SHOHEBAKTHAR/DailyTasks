import java.io.*;
public class DataOutputStreamDemo {
public static void main(String args[])throws IOException{
FileOutputStream fos=new FileOutputStream("file2.txt");
DataOutputStream dos=new DataOutputStream(fos);
dos.writeInt(10);
dos.writeUTF("Shoheb Akthar");
dos.writeDouble(3.763);
System.out.print("File Created");
dos.close();
fos.close();
}
}
