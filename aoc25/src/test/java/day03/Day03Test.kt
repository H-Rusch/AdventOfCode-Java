package day03

import aoc.loadExample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day03Test {

    val filename = "day03.txt"

    @Test
    fun part1Example() {
        val input = loadExample(filename)
        val subject = Day03()

        val result = subject.part1(input)

        assertThat(result).isEqualTo(357L)
    }

    @Test
    fun part2Example() {
        val input = loadExample(filename)
        val subject = Day03()

        val result = subject.part2(input)

        assertThat(result).isEqualTo(3121910778619)
    }

    @ParameterizedTest
    @MethodSource("getMaxJoltage1Arguments")
    fun getMaxJoltage1WorksCorrectly(bankString: String, expected: Long) {
        val bank = convertBankString(bankString)

        assertThat(getMaxJoltage1(bank)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("getMaxJoltage2Arguments")
    fun getMaxJoltage2WorksCorrectly(bankString: String, expected: Long) {
        val bank = convertBankString(bankString)

        assertThat(getMaxJoltage2(bank)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun getMaxJoltage1Arguments(): Stream<Arguments> {
            return Stream.of(
                arguments("987654321111111", 98),
                arguments("811111111111119", 89),
                arguments("234234234234278", 78),
                arguments("818181911112111", 92),
            )
        }

        @JvmStatic
        fun getMaxJoltage2Arguments(): Stream<Arguments> {
            return Stream.of(
                arguments("987654321111111", 987654321111),
                arguments("811111111111119", 811111111119),
                arguments("234234234234278", 434234234278),
                arguments("818181911112111", 888911112111),
            )
        }
    }

    fun convertBankString(bankString: String): List<Int> =
        bankString.asSequence().map { it.digitToInt() }.toList()
}