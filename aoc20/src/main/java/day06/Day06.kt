package day06

import AbstractDay2020

fun main() {
    Day06().executeParts()
}

class Day06 : AbstractDay2020(6) {

    override fun part1(input: String): Any {
        return parse(input)
            .map { evaluateGroup(it) { acc, next -> acc.plus(next) } }
            .sumOf { it.size }
    }

    override fun part2(input: String): Any {
        return parse(input)
            .map { evaluateGroup(it) { acc, next -> acc.intersect(next) } }
            .sumOf { it.size }
    }

    private fun evaluateGroup(
        group: List<Set<Char>>,
        operation: (acc: Set<Char>, Set<Char>) -> Set<Char>
    ): Set<Char> {
        return group.reduce(operation)
    }

    private fun parse(input: String): List<List<Set<Char>>> {
        return input.split("\n\n")
            .map { parseGroup(it) }
    }

    private fun parseGroup(group: String): List<Set<Char>> {
        return group.lines()
            .map { it.toCharArray().toSet() }
    }
}