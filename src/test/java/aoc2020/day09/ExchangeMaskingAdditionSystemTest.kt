package aoc2020.day09

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExchangeMaskingAdditionSystemTest {

    private val values: List<Long> = loadExample(2020, "day09.txt")
        .lines()
        .map { it.toLong() }

    @Test
    fun findInvalidValueExample() {
        val size = 5

        assertThat(findInvalidValue(values, size))
            .isEqualTo(127)
    }


    @Test
    fun findContiguousSumExample() {
        assertThat(findContiguousSum(127, values))
            .isEqualTo(62)
    }
}