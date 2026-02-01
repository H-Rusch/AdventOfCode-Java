package aoc

import kotlinx.coroutines.*
import java.time.Duration
import java.time.Instant

abstract class AbstractDay(private val year: Int, private val day: Int) {

    abstract fun part1(input: String): Any
    abstract fun part2(input: String): Any

    fun executeParts() {
        val input = fetchInput(year, day)
        println("$year Day $day:\n")

        //warmUpJvm(input)

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

    /**
     *  Warm up JVM to get more realistic measurements.
     *  Cancel execution after 1 second so the preparation does not take too long.
     */
    private fun warmUpJvm(input: String) {
        runBlocking {
            try {
                withTimeout(1_000) {
                    coroutineScope {
                        launch { part1(input) }
                        launch { part2(input) }
                    }
                }
            } catch (_: TimeoutCancellationException) {
                // ignored
            }
        }
    }
}