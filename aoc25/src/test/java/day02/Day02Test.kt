package day02

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day02Test {

    val input = "day02.txt"

    @Test
    fun part1Example() {
        val input = loadExample(input)
        val subject = Day02()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(1227775554L)
    }

    @Test
    fun part2Example() {
        val input = loadExample(input)
        val subject = Day02()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(4174379265L)
    }

    @ParameterizedTest
    @MethodSource("isValid1Arguments")
    fun isValid1WorksCorrectly(id: String, expected: Boolean) {
        assertThat(isValidId1(id)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("isValid2Arguments")
    fun isValid2WorksCorrectly(id: String, expected: Boolean) {
        assertThat(isValidId2(id)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun isValid1Arguments(): Stream<Arguments> {
            return Stream.of(
                arguments("101", true),
                arguments("55", false),
                arguments("6464", false),
                arguments("123123", false),
            )
        }

        @JvmStatic
        fun isValid2Arguments(): Stream<Arguments> {
            return Stream.of(
                arguments("101", true),
                arguments("123456", true),
                arguments("124512", true),
                arguments("12341234", false),
                arguments("123123123", false),
                arguments("1212121212", false),
                arguments("1111111", false),
            )
        }
    }
}