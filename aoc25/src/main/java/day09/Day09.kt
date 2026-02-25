package day09

import AbstractDay2025
import util.collections.pairwise
import util.grid.Point
import kotlin.math.abs


fun main() {
    Day09().executeParts()
}

fun rectangleAreaBetween(point1: Point, point2: Point): Long {
    return (abs(point1.x - point2.x) + 1).toLong() * (abs(point1.y - point2.y) + 1).toLong()
}

class Day09 : AbstractDay2025(9) {

    override fun part1(input: String): Any {
        val points = parseInput(input)

        return pairwise(points)
            .map { pair -> rectangleAreaBetween(pair.first, pair.second) }
            .max()
    }

    override fun part2(input: String): Any {
        return 0
    }

    fun parseInput(input: String): List<Point> {
        return input.lines()
            .map { line -> line.split(",").map { Integer.parseInt(it) } }
            .map { Point(it[0], it[1]) }
    }
}
