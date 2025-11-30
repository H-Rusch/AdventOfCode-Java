package day09

import AbstractDay2020

fun main() {
    Day09().executeParts()
}

class Day09 : AbstractDay2020(9) {

    val size: Int = 25

    override fun part1(input: String): Any {
        val numbers = parse(input)
        return findInvalidValue(numbers, size)
    }

    override fun part2(input: String): Any {
        val numbers = parse(input)
        val invalidValue = findInvalidValue(numbers, size)

        return findContiguousSum(invalidValue, numbers)
    }

    private fun parse(input: String): List<Long> {
        return input.lines()
            .map { it.toLong() }
    }
}