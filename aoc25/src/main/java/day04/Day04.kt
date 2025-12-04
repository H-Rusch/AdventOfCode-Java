package day04

import AbstractDay2025
import util.grid.Point


fun main() {
    Day04().executeParts()
}

class Day04 : AbstractDay2025(4) {

    override fun part1(input: String): Any {
        val rolls = parseInput(input)

        return reachableRolls(rolls).count()
    }

    override fun part2(input: String): Any {
        var rolls = parseInput(input)
        val startingCount = rolls.count()

        while (true) {
            val rollsToCleanUp = reachableRolls(rolls)

            if (rollsToCleanUp.isEmpty()) {
                break
            }

            rolls = rolls.minus(rollsToCleanUp)
        }

        return startingCount - rolls.count()
    }

    fun reachableRolls(rolls: Set<Point>): Set<Point> {
        return rolls.filter {
            it.allAdjacent().filter { adj -> rolls.contains(adj) }.size < 4
        }.toSet()
    }

    fun parseInput(input: String): Set<Point> = input.lines()
        .flatMapIndexed { x, row ->
            row.withIndex()
                .filter { it.value == '@' }
                .map { (y, _) -> Point(x, y) }
        }.toMutableSet()
}
