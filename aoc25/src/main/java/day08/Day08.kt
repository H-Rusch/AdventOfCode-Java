package day08

import AbstractDay2025
import util.grid.Point3D
import util.grid.euclidianDistance


fun main() {
    Day08().executeParts()
}

class Day08() : AbstractDay2025(8) {

    override fun part1(input: String): Any = part1(input, 1000)

    fun part1(input: String, iterations: Int = 1000): Any {
        val points = parseInput(input)
        val circuits = points.associateWithTo(mutableMapOf()) { setOf(it) }

        closestPairs(points)
            .take(iterations)
            .forEach { (pointA, pointB) -> connect(circuits, pointA, pointB) }

        return circuits.values.distinct()
            .map { it.size }
            .sortedDescending()
            .take(3)
            .reduce { acc, current -> acc * current }
    }

    override fun part2(input: String): Any {
        val points = parseInput(input)
        val circuits = points.associateWithTo(mutableMapOf()) { setOf(it) }

        val closestPairs = closestPairs(points).iterator()

        while (true) {
            val (pointA, pointB) = closestPairs.next()
            connect(circuits, pointA, pointB)

            if (circuits.values.distinct().size == 1) {
                return pointA.x * pointB.x
            }
        }
    }

    private fun connect(
        circuits: MutableMap<Point3D, Set<Point3D>>,
        pointA: Point3D,
        pointB: Point3D
    ) {
        val combined = circuits[pointA]!!.union(circuits[pointB]!!)

        for (point in combined) {
            circuits[point] = combined
        }
    }

    private fun closestPairs(points: List<Point3D>): Sequence<Pair<Point3D, Point3D>> =
        allPairs(points)
            .sortedBy { euclidianDistance(it.first, it.second) }


    private fun allPairs(points: List<Point3D>): Sequence<Pair<Point3D, Point3D>> = sequence {
        for ((i, pointA) in points.withIndex()) {
            for (pointB in points.subList(i + 1, points.size)) {
                yield(Pair(pointA, pointB))
            }
        }
    }

    fun parseInput(input: String): List<Point3D> {
        return input.lines()
            .map { line -> line.split(",").map { Integer.parseInt(it) } }
            .map { Point3D(it[0], it[1], it[2]) }
    }
}
