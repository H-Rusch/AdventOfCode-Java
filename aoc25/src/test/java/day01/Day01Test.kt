package day01

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun part1Example() {
        val input = loadExample("day01.txt")
        val subject = Day01()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun part2Example() {
        val input = loadExample("day01.txt")
        val subject = Day01()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun part2BigRotationCountsMultipleTimes() {
        val input = "R1000"
        val subject = Day01()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(10)
    }
}