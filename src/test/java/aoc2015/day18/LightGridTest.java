package aoc2015.day18;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightGridTest {

    @Test
    void part1Example() {
        String input = InputFetcher.loadExample(2015, 18);
        var lightGrid = new LightGrid(input);
        int steps = 4;
        int expectedResult = 4;

        lightGrid.simulation(steps);

        assertEquals(expectedResult, lightGrid.countLitLights());
    }
}
