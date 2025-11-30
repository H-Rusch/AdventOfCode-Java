package aoc15.day24;

import aoc15.AbstractDay2015;
import java.util.List;
import lombok.NonNull;

public class Day24 extends AbstractDay2015 {

  public Day24() {
    super(24);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var presentBalancer = new PresentBalancer(parseInput(input), 3);

    return presentBalancer.findFirstGroupsEntanglement();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var presentBalancer = new PresentBalancer(parseInput(input), 4);

    return presentBalancer.findFirstGroupsEntanglement();
  }

  private List<Integer> parseInput(String input) {
    return input.lines().map(Integer::parseInt).toList();
  }

  public static void main(String[] args) {
    new Day24().executeParts();
  }
}
