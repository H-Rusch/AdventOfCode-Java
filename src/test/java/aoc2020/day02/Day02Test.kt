package aoc2020.day02

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Test {

    val input: String = loadExample(2020, "day02.txt")

    @Test
    fun part1Example() {
        val subject = Day02()

        assertThat(subject.part1(input))
            .isEqualTo(2)
    }

    @Test
    fun part2Example() {
        val subject = Day02()

        assertThat(subject.part2(input))
            .isEqualTo(1)
    }
}