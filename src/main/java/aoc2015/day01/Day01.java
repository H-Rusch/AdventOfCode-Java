package aoc2015.day01;

import aoc2015.AbstractDay2015;
import lombok.NonNull;

public class Day01 extends AbstractDay2015 {

  Day01() {
    super(1);
  }

  @NonNull
  @Override
  public Integer part1(@NonNull String input) {
    int floor = 0;

    for (char c : input.toCharArray()) {
      if (c == '(') {
        floor += 1;
      } else {
        floor -= 1;
      }
    }

    return floor;
  }

  @NonNull
  @Override
  public Integer part2(@NonNull String input) {
    int floor = 0;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (c == '(') {
        floor += 1;
      } else {
        floor -= 1;
      }

      if (floor == -1) {
        return i + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    new Day01().executeParts();
  }
}
