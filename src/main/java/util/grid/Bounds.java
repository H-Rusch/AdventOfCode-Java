package util.grid;

import java.util.stream.Stream;

public record Bounds(int minX, int maxX, int minY, int maxY) {

    public boolean isInbound(Point point) {
        return this.minX <= point.x() && point.x() <= maxX &&
            this.minY <= point.y() && point.y() <= maxY;
    }

    public Stream<Point> filterInBounds(Stream<Point> points) {
        return points.filter(this::isInbound);
    }
}
