package aoc2015.day03;

import aoc2015.AbstractDay2015;
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
      pos = pos.move(Direction.fromChar(c));
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
      char c = input.charAt(i);
      if (i % 2 == 0) {
        santa = santa.move(Direction.fromChar(c));
        visited.add(santa);
      } else {
        robot = robot.move(Direction.fromChar(c));
        visited.add(robot);
      }
    }

    return visited.size();
  }

  public static void main(String[] args) {
    new Day03().executeParts();
  }
}
