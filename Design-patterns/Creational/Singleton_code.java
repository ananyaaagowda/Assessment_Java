package Creational;

class Singleton {
    private static Singleton instance;
    
    // Private constructor prevents instantiation from other classes
    private Singleton() {}

    // Static method to get the only instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class Singleton_code {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}

//refer explanation.txt for more information