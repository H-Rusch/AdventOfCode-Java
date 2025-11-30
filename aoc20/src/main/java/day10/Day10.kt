package day10

import AbstractDay2020

fun main() {
    Day10().executeParts()
}

class Day10 : AbstractDay2020(10) {

    override fun part1(input: String): Any {
        val adapters = parse(input)
        val differences = countDifferences(adapters)

        return (differences[1] ?: 0) * (differences[3] ?: 0)
    }

    override fun part2(input: String): Any {
        val adapters = parse(input)

        val possibilities = mutableMapOf(0 to 1L)
        adapters.forEachIndexed { i, current ->
            val currentPossibilities = possibilities[current] ?: 0

            for (nextIndex in i + 1..i + 3) {
                if (nextIndex < adapters.size && adapters[nextIndex] - current <= 3) {
                    possibilities.merge(adapters[nextIndex], currentPossibilities, Long::plus)
                } else {
                    break
                }
            }
        }

        return possibilities.values.max()
    }

    private fun countDifferences(adapters: List<Int>): Map<Int, Int> {
        return adapters.zipWithNext { a, b -> b - a }
            .groupingBy { it }
            .eachCount()
    }

    private fun parse(input: String): List<Int> {
        val adapters = input.lines()
            .map { it.toInt() }
            .toMutableList()

        adapters.add(0)
        adapters.sort()
        adapters.add(adapters.last() + 3)

        return adapters
    }
}