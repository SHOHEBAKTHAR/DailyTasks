class stu{
   private String roll;
   private int marks;

   public stu(String roll, int marks){
       this.roll = roll;
       this.marks = marks;
   }
    public String getroll() {
        return roll;
    }
    public void setroll(String roll) {
        this.roll = roll;
    }
    public void setmarks(int marks) {
       this.marks = marks;
    }
    public int getmarks() {
        return marks;
    }

}
public class Encapsulation {
    public static void main(String[] args) {
        stu st = new stu("134245",85);
        System.out.print(st.getroll()+" "+st.getmarks());
    }
}