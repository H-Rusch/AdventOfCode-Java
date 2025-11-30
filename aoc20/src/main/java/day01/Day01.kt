package day01

import AbstractDay2020


fun main() {
    Day01().executeParts()
}

class Day01 : AbstractDay2020(1) {

    private val target = 2020

    override fun part1(input: String): Any {
        val numbers: List<Int> = parseInput(input)

        for (i in 0 until numbers.size - 1) {
            for (j in i until numbers.size) {
                if (numbers[i] + numbers[j] == target) {
                    return numbers[i] * numbers[j]
                }
            }
        }

        return Unit
    }

    override fun part2(input: String): Any {
        val numbers: List<Int> = parseInput(input)

        for (i in 0 until numbers.size - 2) {
            for (j in i until numbers.size - 1) {
                for (k in j until numbers.size) {
                    if (numbers[i] + numbers[j] + numbers[k] == target) {
                        return numbers[i] * numbers[j] * numbers[k]
                    }
                }
            }
        }

        return Unit
    }

    fun parseInput(input: String): List<Int> =
        input.lines().stream().map { str -> str.toInt() }.toList()
}