package aoc2015.day02;

import aoc2015.AbstractDay2015;
import java.util.Arrays;
import lombok.NonNull;

public class Day02 extends AbstractDay2015 {

  Day02() {
    super(2);
  }

  @NonNull
  @Override
  public Integer part1(@NonNull String input) {
    return input
        .lines()
        .mapToInt(line -> {
          int[] dims = Arrays.stream(line.split("x")).mapToInt(Integer::valueOf).toArray();
          int[] sides = new int[]{dims[0] * dims[1], dims[0] * dims[2], dims[1] * dims[2]};
          Arrays.sort(sides);

          return 2 * Arrays.stream(sides).sum() + sides[0];
        }).sum();
  }

  @NonNull
  @Override
  public Integer part2(@NonNull String input) {
    return input
        .lines()
        .mapToInt(line -> {
          int[] dims = Arrays.stream(line.split("x")).mapToInt(Integer::valueOf).toArray();
          Arrays.sort(dims);

          return 2 * (dims[0] + dims[1]) + Arrays.stream(dims).reduce(1, (v1, v2) -> v1 * v2);
        }).sum();
  }

  public static void main(String[] args) {
    new Day02().executeParts();
  }
}
