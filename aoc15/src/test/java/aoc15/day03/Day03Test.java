package aoc15.day03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Day03Test {

  @ParameterizedTest
  @CsvSource({
      ">, 2",
      "^>v<, 4",
      "^v^v^v^v^v^v, 2"
  })
  void part1Test(String input, int expectedResult) {
    var day = new Day03();

    assertThat(day.part1(input))
        .isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({
      "^v, 3",
      "^>v<, 3",
      "^v^v^v^v^v, 11"
  })
  void part2Test(String input, int expectedResult) {
    var day = new Day03();

    assertThat(day.part2(input))
        .isEqualTo(expectedResult);
  }
}
