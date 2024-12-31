interface Vechile {
    void start();
    void stop();
}

class bike implements Vechile {
    @Override
    public void start() {
        System.out.println("start the bike....");
    }
    
    @Override
    public void stop() {
        System.out.println("stop the bike...");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vechile bike = new bike(); // Polymorphism
        
        bike.start(); 
        bike.stop();       

       
    }
}
