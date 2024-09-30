package Behavioural;

abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int level);
}

class LowLevelHandler extends Handler {
    public void handleRequest(int level) {
        if (level <= 1) {
            System.out.println("LowLevelHandler handling request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(level);
        }
    }
}

class HighLevelHandler extends Handler {
    public void handleRequest(int level) {
        if (level > 1) {
            System.out.println("HighLevelHandler handling request.");
        }
    }
}

public class chain_of_responsibility {
    public static void main(String[] args) {
        Handler lowHandler = new LowLevelHandler();
        Handler highHandler = new HighLevelHandler();
        
        lowHandler.setNextHandler(highHandler);

        lowHandler.handleRequest(1); // Handled by LowLevelHandler
        lowHandler.handleRequest(2); // Handled by HighLevelHandler
    }
}

//refer explanation.txt for more information