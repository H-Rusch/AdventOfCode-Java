package aoc2015.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day10Test {

  @ParameterizedTest
  @MethodSource("provideParameters")
  void transformationTest(String input, String expectedOutput) {
    SequenceTransformer transformer = new SequenceTransformer(input);
    transformer.transform();

    assertEquals(expectedOutput, transformer.getSequence());
  }

  private static Stream<Arguments> provideParameters() {
    return Stream.of(
        Arguments.of("1", "11"),
        Arguments.of("11", "21"),
        Arguments.of("21", "1211"),
        Arguments.of("1211", "111221"),
        Arguments.of("111221", "312211")
    );
  }
}
