public class Inheritance {
    public static void main(String[] args) {
        electriccar e = new electriccar();
        e.ch();
        e.dr();
        e.start();

    }
}

class Vechile{
    void start() {
        System.out.println("Vechile starts....");
    }
}
class bike extends Vechile{
    void dr() {
        System.out.println("bike driving....");
    }
}
class electriccar extends bike{
    void ch(){
        System.out.println("electriccar charging....");
    }
}
