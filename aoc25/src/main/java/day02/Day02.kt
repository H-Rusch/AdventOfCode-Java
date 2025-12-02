package day02

import AbstractDay2025


fun main() {
    Day02().executeParts()
}

fun isValidId1(id: String): Boolean {
    if (id.length % 2 == 1) {
        return true
    }

    val middle = id.length / 2
    return id.take(middle) != id.substring(middle)
}

fun isValidId2(id: String): Boolean {
    for (windowSize in 1..id.length / 2) {
        val windows = id.windowed(windowSize, windowSize, true)
        if (windows.toSet().size == 1) {
            return false
        }
    }

    return true
}

class Day02 : AbstractDay2025(2) {

    override fun part1(input: String): Any {
        val idRanges = parseInput(input)

        return calculateInvalidSum(idRanges, ::isValidId1)
    }

    override fun part2(input: String): Any {
        val idRanges = parseInput(input)

        return calculateInvalidSum(idRanges, ::isValidId2)
    }

    fun calculateInvalidSum(idRanges: List<IdRange>, isValid: (String) -> Boolean): Long {
        return idRanges.parallelStream()
            .flatMap { range ->
                range.iterate().filter { !isValid(it.toString()) }
            }
            .reduce(0) { l1, l2 -> l1 + l2 }
    }


    fun parseInput(input: String): List<IdRange> = input.split(',')
        .stream()
        .map {
            val parts = it.split('-')
            IdRange(parts[0].toLong(), parts[1].toLong())
        }
        .toList()
}