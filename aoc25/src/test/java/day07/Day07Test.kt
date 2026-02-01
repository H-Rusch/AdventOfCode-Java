package day07

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day07Test {

    val filename = "day07.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day07()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(21)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day07()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(0)
    }
}
