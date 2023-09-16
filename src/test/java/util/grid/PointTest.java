package util.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {

    @Test
    void adjacentProducesFourPoints() {
        var point = new Point(0, 0);
        int expectedSize = 4;

        var adjacent = point.getAdjacent();

        assertEquals(expectedSize, adjacent.toList().size());
    }

    @Test
    void adjacentProducesCorrectValues() {
        var point = new Point(5, 5);

        var adjacent = point.getAdjacent();

        assertTrue(adjacent.anyMatch(p -> p.x() == 6 && p.y() == 5));
        assertTrue(adjacent.anyMatch(p -> p.x() == 4 && p.y() == 5));
        assertTrue(adjacent.anyMatch(p -> p.x() == 5 && p.y() == 4));
        assertTrue(adjacent.anyMatch(p -> p.x() == 5 && p.y() == 6));
    }

    @Test
    void allAdjacentProducesEightPoints() {
        var point = new Point(0, 0);
        int expectedSize = 8;

        var adjacent = point.getAllAdjacent();

        assertEquals(expectedSize, adjacent.toList().size());
    }

    @Test
    void allAdjacentProducesCorrectValues() {
        var point = new Point(5, 5);

        var adjacent = point.getAllAdjacent();

        assertTrue(adjacent.anyMatch(p -> p.x() == 6 && p.y() == 5));
        assertTrue(adjacent.anyMatch(p -> p.x() == 4 && p.y() == 5));
        assertTrue(adjacent.anyMatch(p -> p.x() == 5 && p.y() == 4));
        assertTrue(adjacent.anyMatch(p -> p.x() == 5 && p.y() == 6));

        assertTrue(adjacent.anyMatch(p -> p.x() == 4 && p.y() == 4));
        assertTrue(adjacent.anyMatch(p -> p.x() == 6 && p.y() == 4));
        assertTrue(adjacent.anyMatch(p -> p.x() == 4 && p.y() == 6));
        assertTrue(adjacent.anyMatch(p -> p.x() == 6 && p.y() == 6));
    }
}
