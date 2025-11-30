package util.grid

import kotlin.math.abs

@JvmRecord
data class Point(val x: Int, val y: Int) {

    fun move(direction: Direction, amount: Int = 1): Point {
        return when (direction) {
            Direction.UP -> Point(this.x, this.y - amount)
            Direction.DOWN -> Point(this.x, this.y + amount)
            Direction.LEFT -> Point(this.x - amount, this.y)
            Direction.RIGHT -> Point(this.x + amount, this.y)
            Direction.TOP_LEFT -> Point(this.x - amount, this.y - amount)
            Direction.TOP_RIGHT -> Point(this.x + amount, this.y - amount)
            Direction.BOTTOM_LEFT -> Point(this.x - amount, this.y + amount)
            Direction.BOTTOM_RIGHT -> Point(this.x + amount, this.y + amount)
        }
    }

    fun adjacent(): List<Point> {
        return listOf(Direction.RIGHT, Direction.UP, Direction.LEFT, Direction.DOWN)
            .map { this.move(it) }
    }

    fun allAdjacent(): List<Point> = Direction.entries.map { this.move(it) }

    fun manhattenDistance(other: Point): Int {
        return abs(x - other.x) + abs(y - other.y)
    }

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun times(amount: Int): Point {
        return Point(x * amount, y * amount)
    }
}