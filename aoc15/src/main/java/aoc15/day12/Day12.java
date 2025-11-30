package aoc15.day12;

import aoc15.AbstractDay2015;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.NonNull;

class Day12 extends AbstractDay2015 {

  public Day12() {
    super(12);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    return Pattern.compile("-?\\d+")
        .matcher(input)
        .results()
        .map(MatchResult::group)
        .mapToInt(Integer::valueOf)
        .sum();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    JsonSumNumbers summer = new JsonSumNumbers(input);
    summer.sumWithoutRed();

    return summer.getSum();
  }

  public static void main(String[] args) {
    new Day12().executeParts();
  }
}
