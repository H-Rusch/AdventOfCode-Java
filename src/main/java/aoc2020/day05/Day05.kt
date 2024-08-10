package aoc2020.day05

import aoc2020.AbstractDay2020

fun main() {
    Day05().executeParts()
}

class Day05 : AbstractDay2020(5) {

    override fun part1(input: String): Any {
        return parse(input).map { calculateSeatId(it) }.max()
    }

    override fun part2(input: String): Any {
        return parse(input)
            .map { calculateSeatId(it) }
            .sorted()
            .zipWithNext()
            .find { (a, b) -> b != a + 1 }!!
            .first + 1
    }

    fun calculateSeatId(boardingPass: String): Int {
        val row = convertPassToInteger(boardingPass.substring(0..6))
        val seat = convertPassToInteger(boardingPass.substring(7))

        return row * 8 + seat
    }

    private fun convertPassToInteger(boardingPassInstruction: String): Int {
        val binaryString = boardingPassInstruction.map { char ->
            when (char) {
                'F', 'L' -> '0'
                'B', 'R' -> '1'
                else -> throw IllegalArgumentException("Invalid character in boarding pass: $char")
            }
        }.joinToString("")

        return binaryString.toInt(radix = 2)
    }

    private fun parse(input: String): List<String> = input.lines()
}