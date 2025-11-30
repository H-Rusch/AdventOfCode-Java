package day11

import AbstractDay2020
import util.grid.Point

fun main() {
    Day11().executeParts()
}

class Day11 : AbstractDay2020(11) {

    override fun part1(input: String): Any {
        val seatCoordinates = parse(input)
        val adjacentSeatSimulation = AdjacentSeatSimulation(seatCoordinates)

        return adjacentSeatSimulation.runSimulation()
    }

    override fun part2(input: String): Any {
        val seatCoordinates = parse(input)
        val firstSeenSeatSimulation = FirstSeenSeatSimulation(seatCoordinates)

        return firstSeenSeatSimulation.runSimulation()
    }


    private fun parse(input: String): Set<Point> {
        val seatCoordinates = mutableSetOf<Point>()

        input.lines().forEachIndexed { y, line ->
            line.forEachIndexed { x, ch ->
                if (ch == 'L') {
                    seatCoordinates.add(Point(x, y))
                }
            }
        }

        return seatCoordinates
    }
}