package Structural;

// Subject Interface
interface Image {
    void display();
}

// Real subject class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Load image only when needed
        }
        realImage.display();
    }
}

// Testing the Proxy Pattern
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("AdapterPattern-output.png");

        image.display();
        System.out.println("");

        // Image will not be loaded again; proxy will reuse the loaded image
        image.display();
    }
}

//refer explanation.txt for more information
