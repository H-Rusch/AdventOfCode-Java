package aoc15.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PasswordIncrementerTest {

  @ParameterizedTest
  @MethodSource("passwordIterationParameters")
  void basicIncrementationShouldWork(String input, String expectedOutput) {
    PasswordIncrementer p = new PasswordIncrementer(input);

    p.incrementPassword();

    assertEquals(expectedOutput, p.getPassword());
  }

  private static Stream<Arguments> passwordIterationParameters() {
    return Stream.of(
        Arguments.of("xx", "xy"),
        Arguments.of("xy", "xz"),
        Arguments.of("xz", "ya"),
        Arguments.of("zz", "aa")
    );
  }
}
