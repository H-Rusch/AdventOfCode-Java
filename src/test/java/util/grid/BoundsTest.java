package util.grid;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BoundsTest {

    @ParameterizedTest
    @MethodSource("provideInboundPoints")
    void inboundPointIsFound(Point point) {
        var bound = new Bounds(0, 100, 0, 100);

        assertTrue(bound.isInbound(point));
    }


    private static List<Point> provideInboundPoints() {
        return List.of(
                new Point(0, 50),
                new Point(99, 50),
                new Point(50, 0),
                new Point(50, 99),
                new Point(50, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("provideOutOfBoundsPoints")
    void pointOfOfBoundsFails(Point point) {
        var bound = new Bounds(0, 100, 0, 100);

        assertFalse(bound.isInbound(point));
    }


    private static List<Point> provideOutOfBoundsPoints() {
        return List.of(
                new Point(-1, 50),
                new Point(101, 50),
                new Point(5, -79),
                new Point(50, 110),
                new Point(-50, -50)
        );
    }
}
