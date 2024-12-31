import java.io.*;
public class DataInputStreamDemo {
public static void main(String args[])throws IOException{
FileInputStream fis=new FileInputStream("file2.txt");
DataInputStream dis=new DataInputStream(fis);
int n=dis.readInt();
System.out.println(n);
String s=dis.readUTF();
System.out.println(s);
double d=dis.readDouble();
System.out.println(d);
dis.close();
fis.close();
}
}
