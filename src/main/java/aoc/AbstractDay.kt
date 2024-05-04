package aoc

import util.days.InputFetcher
import java.time.Duration
import java.time.Instant

abstract class AbstractDay(private val year: Int, private val day: Int) {

    abstract fun part1(input: String): Any
    abstract fun part2(input: String): Any

    fun executeParts() {
        val input = InputFetcher.fetchInput(year, day)
        println("$year Day $day:\n")

        executePart(1) { part1(input) }
        executePart(2) { part2(input) }
    }

    private fun executePart(partNumber: Int, part: () -> Any) {
        val result = executeAndMeasure { part() }
        println("Part $partNumber: ${result.first}")
        println(" ${formatDuration(result.second)}")
    }

    private fun executeAndMeasure(part: () -> Any): Pair<Any, Duration> {
        val start = Instant.now()
        val result: Any = part()
        val end = Instant.now()

        return Pair(result, Duration.between(start, end))
    }
}