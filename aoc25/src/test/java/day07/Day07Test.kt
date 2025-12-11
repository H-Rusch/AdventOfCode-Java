package day07

import aoc15.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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
