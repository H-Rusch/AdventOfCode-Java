package aoc2020.day03

import aoc2020.AbstractDay2020
import util.grid.Point
import java.util.stream.Stream

fun main() {
    Day03().executeParts()
}

class Day03 : AbstractDay2020(3) {

    override fun part1(input: String): Any {
        val areaMap = parse(input)

        return descend(areaMap, Slope(3, 1))
    }

    override fun part2(input: String): Any {
        val areaMap = parse(input)

        return Stream.of(
            Slope(1, 1),
            Slope(3, 1),
            Slope(5, 1),
            Slope(7, 1),
            Slope(1, 2)
        )
            .map { descend(areaMap, it) }
            .reduce(Int::times)
            .orElse(0)
    }

    private fun descend(areaMap: AreaMap, slope: Slope): Int {
        var point = Point(0, 0)
        var treeCount = 0

        while (!areaMap.hasReachedBottom(point)) {
            if (areaMap.getTile(point) == Tile.TREE) {
                treeCount++
            }
            point = slope.nextPoint(point)
        }

        return treeCount
    }

    private fun parse(input: String): AreaMap {
        val map = input.lines()
            .map { line ->
                line.toCharArray()
                    .map { Tile.from(it) }
                    .toList()
            }
            .toList()

        return AreaMap(map)
    }
}