package aoc15.day03;

import aoc15.AbstractDay2015;
import java.util.HashSet;
import java.util.Set;
import lombok.NonNull;
import util.grid.Direction;
import util.grid.Point;

class Day03 extends AbstractDay2015 {

  Day03() {
    super(3);
  }

  @NonNull
  @Override
  public Integer part1(@NonNull String input) {
    Set<Point> visited = new HashSet<>();

    Point pos = new Point(0, 0);
    visited.add(pos);
    for (char c : input.toCharArray()) {
      Direction direction = Direction.Companion.fromChar(c);
      pos = pos.move(direction, 1);
      visited.add(pos);
    }

    return visited.size();
  }

  @NonNull
  @Override
  public Integer part2(@NonNull String input) {
    Set<Point> visited = new HashSet<>();

    Point santa = new Point(0, 0);
    Point robot = new Point(0, 0);
    visited.add(santa);

    for (int i = 0; i < input.length(); i++) {
      Direction direction = Direction.Companion.fromChar(input.charAt(i));

      if (i % 2 == 0) {
        santa = santa.move(direction, 1);
        visited.add(santa);
      } else {
        robot = robot.move(direction, 1);
        visited.add(robot);
      }
    }

    return visited.size();
  }

  public static void main(String[] args) {
    new Day03().executeParts();
  }
}
