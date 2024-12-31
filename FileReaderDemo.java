import java.io.*;
public class FileReaderDemo{
public static void main(String args[]) throws IOException{
FileReader fr=new FileReader("file3.txt");
int n;
while((n=fr.read())!=-1){ System.out.print((char)n);}
fr.close();

}
}