package aoc15.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day12Test {

  @ParameterizedTest
  @MethodSource("part1ExampleValues")
  void part1Examples(String input, Integer expectedOutput) {
    assertEquals(expectedOutput, new Day12().part1(input));
  }

  private static Stream<Arguments> part1ExampleValues() {
    return Stream.of(
        Arguments.of("[1,2,3]", 6),
        Arguments.of("{1,2,3}", 6),
        Arguments.of("[[[3]]]", 3),
        Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
        Arguments.of("{\"a\":[-1,1]}", 0),
        Arguments.of("[-1,{\"a\":1}]", 0),
        Arguments.of("{}", 0),
        Arguments.of("[]", 0)
    );
  }

  @ParameterizedTest
  @MethodSource("part2ExampleValues")
  void part2Examples(String input, Integer expectedOutput) {
    assertEquals(expectedOutput, new Day12().part2(input));
  }

  private static Stream<Arguments> part2ExampleValues() {
    return Stream.of(
        Arguments.of("[1,2,3]", 6),
        Arguments.of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
        Arguments.of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
        Arguments.of("[1,\"red\",5]", 6)
    );
  }
}
