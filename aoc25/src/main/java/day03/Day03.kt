package day03

import AbstractDay2025
import kotlin.math.pow


fun main() {
    Day03().executeParts()
}

fun getMaxJoltage1(bank: List<Int>): Long = getMaxJoltageOfSize(bank, 2)

fun getMaxJoltage2(bank: List<Int>): Long = getMaxJoltageOfSize(bank, 12)

fun getMaxJoltageOfSize(bank: List<Int>, targetSize: Int): Long {
    var remainingSize = targetSize
    val selectedDigits = mutableListOf<Int>()
    var index = 0

    while (index < bank.size && selectedDigits.size != targetSize) {
        val windowSize = bank.size - index - remainingSize
        val window = bank.slice(index..((windowSize + index).coerceAtMost(bank.size)))

        val selectedDigit = window.max()
        selectedDigits.add(selectedDigit)

        index += window.indexOf(selectedDigit) + 1
        remainingSize--
    }

    return selectedDigits.asReversed()
        .mapIndexed { index, value -> 10.0.pow(index.toDouble()).toLong() * value }
        .sum()
}

class Day03 : AbstractDay2025(3) {

    override fun part1(input: String): Any {
        return parseInput(input)
            .asSequence()
            .map { getMaxJoltage1(it) }
            .sum()
    }

    override fun part2(input: String): Any {
        return parseInput(input)
            .asSequence()
            .map { getMaxJoltage2(it) }
            .sum()
    }

    fun parseInput(input: String): List<List<Int>> = input.lines()
        .asSequence()
        .map { row -> row.asSequence().map { it.digitToInt() }.toList() }
        .toList()
}