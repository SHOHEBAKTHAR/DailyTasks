import java.io.*;
class Book implements Serializable
{
int bno;
String bname;
double price;
public Book(int bno,String bname,double price){
this.bno=bno;
this.bname=bname;
this.price=price;
}
public String toString(){
return bno+" "+bname+" "+price;
}
}
public class DeSerializationDemo{
public static void main(String args[]) throws Exception{
FileInputStream fis=new FileInputStream("book.txt");
ObjectInputStream ois=new ObjectInputStream(fis);
Book b1=(Book) ois.readObject();
System.out.print(b1);
fis.close();
ois.close();
}
}
