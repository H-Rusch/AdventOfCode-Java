package day01

import AbstractDay2025
import kotlin.math.abs


fun main() {
    Day01().executeParts()
}

class Day01 : AbstractDay2025(1) {

    private val radius = 100

    override fun part1(input: String): Any {
        val rotations = parseInput(input)
        var rotation = 50
        var timesAtZero = 0

        for (i in rotations) {
            rotation = (rotation + i).mod(radius)
            if (rotation == 0) {
                timesAtZero++
            }
        }

        return timesAtZero
    }

    override fun part2(input: String): Any {
        val rotations = parseInput(input)
        var rotation = 50
        var timesPassingZero = 0

        for (i in rotations) {
            if (i >= 0) {
                timesPassingZero += (rotation + i) / radius
            } else {
                timesPassingZero += ((radius - rotation) % radius + abs(i)) / radius
            }

            rotation = (rotation + i).mod(radius)
        }

        return timesPassingZero
    }

    fun parseInput(input: String): List<Int> = input.lines()
        .stream()
        .map { parseLine(it) }
        .toList()

    fun parseLine(line: String): Int {
        val rotation = line[0]
        val number = line.substring(1)

        if (rotation == 'L') {
            return -Integer.parseInt(number)
        }
        if (rotation == 'R') {
            return Integer.parseInt(number)
        }
        throw IllegalArgumentException(number)
    }
}