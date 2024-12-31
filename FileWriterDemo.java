import java.io.*;
public class FileWriterDemo{
public static void main(String args[]) throws IOException{
FileWriter fw=new FileWriter("file3.txt");
BufferedWriter bw =new BufferedWriter(fw);
String s="Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy Umesh is a good boy";
bw.write(s);
System.out.print("file created");
bw.close();
fw.close();
}
}