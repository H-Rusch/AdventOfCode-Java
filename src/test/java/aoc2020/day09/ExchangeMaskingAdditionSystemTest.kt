package aoc2020.day09

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExchangeMaskingAdditionSystemTest {

    private val values: List<Long> = loadExample(2020, "day09.txt")
        .lines()
        .map { it.toLong() }

    @Test
    fun findInvalidValue_example() {
        val size = 5

        assertThat(findInvalidValue(values, size))
            .isEqualTo(127)
    }


    @Test
    fun findContiguousSum_example() {
        assertThat(findContiguousSum(127, values))
            .isEqualTo(62)
    }
}