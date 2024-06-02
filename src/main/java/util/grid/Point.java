package util.grid;

import static util.grid.Direction.BOTTOM_LEFT;
import static util.grid.Direction.BOTTOM_RIGHT;
import static util.grid.Direction.DOWN;
import static util.grid.Direction.LEFT;
import static util.grid.Direction.RIGHT;
import static util.grid.Direction.TOP_LEFT;
import static util.grid.Direction.TOP_RIGHT;
import static util.grid.Direction.UP;

import java.util.Objects;
import java.util.stream.Stream;

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

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }

    if (other instanceof Point(int otherX, int otherY)) {
      return otherX == this.x && otherY == this.y;
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
