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
public class SerializationDemo{
public static void main(String args[]) throws Exception{
FileOutputStream fos=new FileOutputStream("book.txt");
ObjectOutputStream oos=new ObjectOutputStream(fos);
Book b=new Book(111,"filehandling",500.0);
oos.writeObject(b);
fos.close();
oos.close();
}
}
