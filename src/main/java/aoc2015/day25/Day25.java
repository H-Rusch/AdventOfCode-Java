package aoc2015.day25;

import aoc2015.AbstractDay2015;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.NonNull;
import util.grid.Point;

public class Day25 extends AbstractDay2015 {

  public Day25() {
    super(25);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var point = parseInput(input);
    var codeGenerator = new CodeGenerator();

    return codeGenerator.calculateAt(point);
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    return "No puzzle :)";
  }

  private Point parseInput(String input) {
    var matcher = Pattern.compile("\\d+").matcher(input);
    var numbers = matcher.results().map(MatchResult::group).toArray(String[]::new);

    return new Point(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
  }

  public static void main(String[] args) {
    new Day25().executeParts();
  }
}
