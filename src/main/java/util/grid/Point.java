package util.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static util.grid.Direction.*;

public record Point(int x, int y) {

    public Point move(Direction dir) {
        return switch (dir) {
            case UP -> new Point(this.x, this.y - 1);
            case DOWN -> new Point(this.x, this.y + 1);
            case LEFT -> new Point(this.x - 1, this.y);
            case RIGHT -> new Point(this.x + 1, this.y);
            case TOP_LEFT -> new Point(this.x - 1, this.y - 1);
            case TOP_RIGHT -> new Point(this.x + 1, this.y - 1);
            case BOTTOM_LEFT -> new Point(this.x - 1, this.y + 1);
            case BOTTOM_RIGHT -> new Point(this.x + 1, this.y + 1);
        };
    }

    public Stream<Point> getAdjacent() {
        return Stream.of(RIGHT, UP, LEFT, DOWN)
                .map(this::move);
    }

    public Stream<Point> getAllAdjacent() {
        return Stream.of(RIGHT, TOP_RIGHT, UP, TOP_LEFT, LEFT, BOTTOM_LEFT, DOWN, BOTTOM_RIGHT)
                .map(this::move);
    }
}
