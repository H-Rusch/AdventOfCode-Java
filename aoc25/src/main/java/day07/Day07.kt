package day07

import AbstractDay2025
import util.grid.Direction
import util.grid.Point


fun main() {
    Day07().executeParts()
}

class Day07 : AbstractDay2025(7) {

    override fun part1(input: String): Any {
        val (start, splits, maxY) = parseInput(input)
        val expanded = mutableListOf(start)
        val visited = mutableSetOf<Point>()

        while (expanded.isNotEmpty()) {
            val current = expanded.removeAt(0)
            if (visited.contains(current) || current.y == maxY) {
                continue
            }
            visited.add(current)

            val next = current.move(Direction.DOWN, 1)
            if (splits.contains(next)) {
                visited.add(next)
                expanded.add(next.move(Direction.LEFT, 1))
                expanded.add(next.move(Direction.RIGHT, 1))
            } else {
                expanded.add(next)
            }
        }

        return splits.intersect(visited).count()
    }

    override fun part2(input: String): Any {
        return 0
    }

    fun parseInput(input: String): Triple<Point, Set<Point>, Int> {
        val lines = input.lines()
        val start = Point(lines[0].indexOf("S"), 0)
        val maxY = lines.size

        val splits = lines.flatMapIndexed { y, row -> row.asSequence().mapIndexed { x, ch -> Point(x, y) to ch } }
            .filter { (_, ch) -> ch == '^' }
            .map { (point, _) -> point }
            .toSet()

        return Triple(start, splits, maxY)
    }
}
