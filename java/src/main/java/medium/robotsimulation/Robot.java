package medium.robotsimulation;

public class Robot {

    private GridPosition position;
    private Orientation orientation;

    Robot(GridPosition initialPosition, Orientation initialOrientation) {
        this.position = initialPosition;
        this.orientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return this.position;
    }

    Orientation getOrientation() {
        return this.orientation;
    }

    void advance() {
        switch (this.orientation) {
            case Orientation.NORTH -> this.position = new GridPosition(this.position.x, this.position.y + 1);
            case Orientation.EAST -> this.position = new GridPosition(this.position.x + 1, this.position.y);
            case Orientation.SOUTH -> this.position = new GridPosition(this.position.x, this.position.y - 1);
            case Orientation.WEST -> this.position = new GridPosition(this.position.x - 1, this.position.y);
        }
    }

    void turnLeft() {
        switch (this.orientation) {
            case Orientation.NORTH -> this.orientation = Orientation.WEST;
            case Orientation.EAST -> this.orientation = Orientation.NORTH;
            case Orientation.SOUTH -> this.orientation = Orientation.EAST;
            case Orientation.WEST -> this.orientation = Orientation.SOUTH;
        }
    }

    void turnRight() {
        switch (this.orientation) {
            case Orientation.NORTH -> this.orientation = Orientation.EAST;
            case Orientation.EAST -> this.orientation = Orientation.SOUTH;
            case Orientation.SOUTH -> this.orientation = Orientation.WEST;
            case Orientation.WEST -> this.orientation = Orientation.NORTH;
        }
    }

    void simulate(String instructions) {

        for (char direction : instructions.toCharArray()) {
            switch (direction) {
                case 'L' -> this.turnLeft();
                case 'R' -> this.turnRight();
                case 'A' -> this.advance();
            }
        }

    }

}
