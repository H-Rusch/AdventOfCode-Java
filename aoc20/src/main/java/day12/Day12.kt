package day12

import AbstractDay2020

fun main() {
    Day12().executeParts()
}

class Day12 : AbstractDay2020(12) {

    override fun part1(input: String): Any {
        val commands = parse(input)
        val ship = Ship()
        commands.forEach { ship.executeCommand(it.first, it.second) }

        return ship.distanceToStart()
    }

    override fun part2(input: String): Any {
        val commands = parse(input)
        val shipWithWaypoint = ShipWithWaypoint()
        commands.forEach { shipWithWaypoint.executeCommand(it.first, it.second) }

        return shipWithWaypoint.distanceToStart()
    }


    private fun parse(input: String): List<Pair<Char, Int>> {
        return input.lines()
            .map { Pair(it[0], it.substring(1).toInt()) }
    }
}