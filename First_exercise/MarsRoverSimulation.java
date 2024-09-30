// Rover Class
import java.util.*;

class Rover {
    private int x, y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void execute(Command command) {
        command.execute(this);
    }

    public void move() {
        switch (direction) {
            case NORTH: this.y++; break;
            case SOUTH: this.y--; break;
            case EAST: this.x++; break;
            case WEST: this.x--; break;
        }
    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public void turnRight() {
        this.direction = direction.right();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction;
    }
}

// Command Interface
interface Command {
    void execute(Rover rover);
}

// Concrete Command: Move
class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}

// Concrete Command: Turn Left
class TurnLeftCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
}

// Concrete Command: Turn Right
class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}

// Enum for Direction
enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction left() {
        switch (this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
        }
        return this;
    }

    public Direction right() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
        }
        return this;
    }
}

// Grid Class
class Grid {
    private int width, height;
    private Set<Point> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(int x, int y) {
        obstacles.add(new Point(x, y));
    }

    public boolean isObstacle(int x, int y) {
        return obstacles.contains(new Point(x, y));
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}

// Point Class for Obstacles
class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

// Main Class to Run the Program
public class MarsRoverSimulation {
    public static void main(String[] args) {
        // Initialize grid and rover
        Grid grid = new Grid(10, 10);
        grid.addObstacle(2, 2);
        Rover rover = new Rover(0, 0, Direction.NORTH);

        // Define commands
        List<Command> commands = Arrays.asList(
            new MoveCommand(),
            new MoveCommand(),
            new TurnRightCommand(),
            new MoveCommand(),
            new TurnLeftCommand(),
            new MoveCommand()
        );

        // Execute commands
        for (Command command : commands) {
            if (grid.isWithinBounds(rover.getX(), rover.getY()) &&
                !grid.isObstacle(rover.getX(), rover.getY())) {
                rover.execute(command);
            } else {
                System.out.println("Obstacle detected or out of bounds!");
                break;
            }
        }

        // Print final status
        System.out.println(rover.getStatus());
    }
}

//basically the commands used are:

// Commands: ['M', 'M', 'R', 'M', 'L', 'M']
// Starting Position: (0, 0, N)
// Grid Size: 10 x 10
// Obstacles: [(2, 2)]
