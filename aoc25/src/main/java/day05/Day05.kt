package day05

import AbstractDay2025
import kotlin.math.max


fun main() {
    Day05().executeParts()
}

fun mergeRanges(ranges: List<ClosedRange<Long>>): List<ClosedRange<Long>> {
    val result = mutableListOf<ClosedRange<Long>>()
    val sortedRanges = ranges.sortedBy { it.start }
    var currentStart = sortedRanges.first().start
    var currentEnd = sortedRanges.first().endInclusive

    for (range in sortedRanges) {
        if (range.start > currentEnd) {
            result.add(currentStart..currentEnd)
            currentStart = range.start
            currentEnd = range.endInclusive
        } else {
            currentEnd = max(currentEnd, range.endInclusive)
        }
    }
    result.add(currentStart..currentEnd)

    return result
}

class Day05 : AbstractDay2025(5) {

    override fun part1(input: String): Any {
        val (freshRanges, ingredients) = parseInput(input)

        return ingredients.count { freshRanges.any { range -> range.contains(it) } }
    }

    override fun part2(input: String): Any {
        val (freshRanges, _) = parseInput(input)
        val mergedRanges = mergeRanges(freshRanges)

        return mergedRanges.sumOf { it.endInclusive - it.start + 1 }
    }

    fun parseInput(input: String): Pair<List<ClosedRange<Long>>, List<Long>> {
        val parts = input.split("\n\n")

        val freshRanges = parts[0].trim().lines().map { parseRange(it) }.toList()
        val ingredients = parts[1].trim().lines().map { it.toLong() }.toList()

        return Pair(freshRanges, ingredients)
    }

    fun parseRange(line: String): ClosedRange<Long> {
        val parts = line.split('-')
        return parts[0].toLong()..parts[1].toLong()
    }
}
