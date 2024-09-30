package Structural;

// Subsystem classes
class CPU {
    public void start() {
        System.out.println("CPU started.");
    }

    public void execute() {
        System.out.println("CPU is executing instructions.");
    }

    public void stop() {
        System.out.println("CPU stopped.");
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory loaded at position " + position);
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("Reading data from Hard Drive.");
        return new byte[size];
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load(1000L, hardDrive.read(0, 512));
        cpu.execute();
    }
}

// Client class
public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

//refer explanation.txt for more information