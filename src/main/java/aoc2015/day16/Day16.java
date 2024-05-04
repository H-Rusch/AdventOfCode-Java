package aoc2015.day16;

import aoc2015.AbstractDay2015;
import java.util.List;
import lombok.NonNull;

public class Day16 extends AbstractDay2015 {

  private SueMatcher sueMatcher;

  public Day16() {
    super(16);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var sues = parseInput(input);
    sueMatcher = new SueMatcher(createExampleSue());

    return findExactlyMatchingSue(sues);
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var sues = parseInput(input);
    sueMatcher = new SueMatcher(createExampleSue());

    return findMatchingSueUsingRanges(sues);
  }

  public Sue createExampleSue() {
    Sue sue = new Sue();
    var fields = sue.getFields();
    fields.put("children", 3);
    fields.put("cats", 7);
    fields.put("samoyeds", 2);
    fields.put("pomeranians", 3);
    fields.put("akitas", 0);
    fields.put("vizslas", 0);
    fields.put("goldfish", 5);
    fields.put("trees", 3);
    fields.put("cars", 2);
    fields.put("perfumes", 1);

    return sue;
  }

  public int findExactlyMatchingSue(List<Sue> sues) {
    for (int i = 0; i < sues.size(); i++) {
      if (sueMatcher.matchesExactly(sues.get(i))) {
        return i + 1; // numbering begins with 1
      }
    }

    throw new NoMatchingSueFoundException("Not found");
  }

  public int findMatchingSueUsingRanges(List<Sue> sues) {
    for (int i = 0; i < sues.size(); i++) {
      if (sueMatcher.matchesWithRanges(sues.get(i))) {
        return i + 1; // numbering begins with 1
      }
    }

    throw new NoMatchingSueFoundException("Not found");
  }

  public static List<Sue> parseInput(String input) {
    return input.lines()
        .map(Sue::fromString)
        .toList();
  }

  public static void main(String[] args) {
    new Day16().executeParts();
  }
}
