package day06

import AbstractDay2025
import util.matrix.transpose


fun main() {
    Day06().executeParts()
}

class Day06 : AbstractDay2025(6) {

    override fun part1(input: String): Any = parseInput1(input).sumOf { it.calculate() }

    override fun part2(input: String): Any = parseInput2(input).sumOf { it.calculate() }

    fun parseInput1(input: String): List<Calculation> {
        val lines = input.lines()
        
        val numbers = mutableMapOf<Int, MutableList<Int>>()
        for (line in lines.subList(0, lines.size - 1)) {
            for ((i, num) in splitWhitespace(line).withIndex()) {
                numbers.putIfAbsent(i, mutableListOf())
                numbers[i]!!.add(num.toInt())
            }
        }

        return buildCalculations(numbers.values.toList(), splitWhitespace(lines.last()))
    }

    fun parseInput2(input: String): List<Calculation> {
        val lines = input.lines()

        // transpose number part of the input to make handling numbers easier
        val matrix = lines.subList(0, lines.size - 1)
            .map { line -> line.asSequence().toList() }
            .toList()
        val transposed = transpose(matrix)

        val numbers = transposed.joinToString(separator = "\n") { it.joinToString(separator = "").trim() }
            .split("\n\n")
            .map { splitWhitespace(it).map { it.toInt() } }

        return buildCalculations(numbers, splitWhitespace(lines.last()))
    }

    fun splitWhitespace(str: String): List<String> = str.split("\\s+".toRegex()).filter { it.isNotEmpty() }

    fun buildCalculations(numbers: List<List<Int>>, operations: List<String>): List<Calculation> {
        return operations
            .mapIndexed { i, op ->
                if (op == "+") {
                    AddingCalculation(numbers[i])
                } else {
                    MultiplyingCalculation(numbers[i])
                }
            }
    }
}
