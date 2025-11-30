package aoc15.day10;

import aoc15.AbstractDay2015;
import lombok.NonNull;


class Day10 extends AbstractDay2015 {

  Day10() {
    super(10);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    return iterateSequence(input, 40).length();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    return iterateSequence(input, 50).length();
  }

  public String iterateSequence(String input, int times) {
    SequenceTransformer transformer = new SequenceTransformer(input.trim());

    for (int i = 0; i < times; i++) {
      transformer.transform();
    }

    return transformer.getSequence();
  }

  public static void main(String[] args) {
    new Day10().executeParts();
  }
}
