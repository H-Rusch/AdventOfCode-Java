package util.grid

import java.util.stream.Stream

@JvmRecord
data class Bounds(val minX: Int, val maxX: Int, val minY: Int, val maxY: Int) {

    fun isInbound(point: Point): Boolean {
        return (minX..maxX).contains(point.x) && (minY..maxY).contains(point.y)
    }

    fun filterInBounds(points: Stream<Point>): Stream<Point> {
        return points.filter {
            this.isInbound(it)
        }
    }
}