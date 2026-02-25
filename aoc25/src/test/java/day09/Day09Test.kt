package day09

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import util.grid.Point
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day09Test {

    val filename = "day09.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day09()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(50L)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day09()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @MethodSource("rectangleAreaBetween")
    fun rectangleAreaWorks(point1: Point, point2: Point, expected: Long) {
        assertThat(rectangleAreaBetween(point1, point2)).isEqualTo(expected)
    }

    private fun rectangleAreaBetween(): Stream<Arguments> {
        return Stream.of(
            arguments(Point(2, 5), Point(9, 7), 24),
            arguments(Point(7, 1), Point(11, 7), 35),
            arguments(Point(7, 3), Point(2, 3), 6),
            arguments(Point(2, 5), Point(11, 1), 50),
        )
    }
}
