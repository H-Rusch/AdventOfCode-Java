package aoc2015.day11;

import aoc2015.AbstractDay2015;
import aoc2015.day11.requirements.ContainTwoPairRequirement;
import aoc2015.day11.requirements.NotContainSelectedLettersRequirement;
import aoc2015.day11.requirements.PasswordRequirement;
import aoc2015.day11.requirements.ThreeIncreasingRequirement;
import java.util.List;
import lombok.NonNull;

class Day11 extends AbstractDay2015 {

  public Day11() {
    super(11);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    return generateNextPassword(input);
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    return generateNextPassword(generateNextPassword(input));
  }

  private String generateNextPassword(String initialPassword) {
    PasswordIncrementer incrementer = new PasswordIncrementer(initialPassword);
    List<PasswordRequirement> requirementList = List.of(
        new NotContainSelectedLettersRequirement(),
        new ContainTwoPairRequirement(),
        new ThreeIncreasingRequirement()
    );

    while (true) {
      incrementer.incrementPassword();
      String candidate = incrementer.getPassword();

      if (requirementList.stream().allMatch(requirement -> requirement.matches(candidate))) {
        return candidate;
      }
    }
  }

  public static void main(String[] args) {
    new Day11().executeParts();
  }
}
