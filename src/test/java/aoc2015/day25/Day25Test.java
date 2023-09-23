package aoc2015.day25;

import org.junit.jupiter.api.Test;
import util.grid.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day25Test {

    @Test
    void codeCountTest() {
        var expected = 17850353;
        var generator = new CodeGenerator();
        var point = new Point(2947, 3029);

        var result = generator.countCodes(point);

        assertEquals(expected, result);
    }
}
