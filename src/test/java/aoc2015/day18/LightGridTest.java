package aoc2015.day18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

class LightGridTest {

  @Test
  void part1Example() {
    String input = InputFetcher.loadExample(2015, 18);
    var lightGrid = new LightGrid(input, false);
    int steps = 4;
    int expectedResult = 4;

    lightGrid.simulation(steps);

    assertEquals(expectedResult, lightGrid.countLitLights());
  }

  @Test
  void part2Example() {
    String input = InputFetcher.loadExample(2015, 18);
    var lightGrid = new LightGrid(input, true);
    int steps = 5;
    int expectedResult = 17;

    lightGrid.simulation(steps);

    assertEquals(expectedResult, lightGrid.countLitLights());
  }
}
