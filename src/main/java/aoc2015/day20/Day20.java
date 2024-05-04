package aoc2015.day20;

import aoc2015.AbstractDay2015;
import lombok.NonNull;


public class Day20 extends AbstractDay2015 {

  private static final int ELF_PRESENTS_1 = 10;
  private static final int ELF_PRESENTS_2 = 11;
  private static final int ELF_REPEATS = 50;

  private int[] housePresents;

  public Day20() {
    super(20);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var targetPresents = Integer.parseInt(input.trim());
    fillPresentArrayPart1(targetPresents);

    return findLowestHouseNumber(targetPresents);
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var targetPresents = Integer.parseInt(input.trim());
    fillPresentArrayPart2(targetPresents);

    return findLowestHouseNumber(targetPresents);
  }

  private void fillPresentArrayPart1(int targetPresents) {
    this.housePresents = new int[targetPresents / ELF_PRESENTS_1];

    for (int i = 1; i < housePresents.length; i++) {
      for (int j = i; j < housePresents.length; j += i) {
        housePresents[j] += ELF_PRESENTS_1 * i;
      }
    }
  }

  private void fillPresentArrayPart2(int targetPresents) {
    this.housePresents = new int[targetPresents / ELF_PRESENTS_2];

    for (int i = 1; i < housePresents.length; i++) {
      int count = 0;
      for (int j = i; j < housePresents.length; j += i) {
        housePresents[j] += ELF_PRESENTS_2 * i;

        count++;
        if (count == ELF_REPEATS) {
          break;
        }
      }
    }
  }

  private int findLowestHouseNumber(int targetPresents) {
    for (int i = 0; i < housePresents.length; i++) {
      if (housePresents[i] >= targetPresents) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    new Day20().executeParts();
  }
}
