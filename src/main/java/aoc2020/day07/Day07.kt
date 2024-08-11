package aoc2020.day07

import aoc2020.AbstractDay2020

fun main() {
    Day07().executeParts()
}

class Day07 : AbstractDay2020(7) {

    private val bagPattern = Regex("(\\d+) (\\w+ \\w+) bag")
    private val searchFor = "shiny gold"

    override fun part1(input: String): Any {
        val bagMap = parse(input)
        val bagChecker = BagChecker(bagMap)

        return bagChecker.countContainedBy(searchFor)
    }

    override fun part2(input: String): Any {
        val bagMap = parse(input)
        val bagChecker = BagChecker(bagMap)

        return bagChecker.sumContainedBags(searchFor)
    }

    private fun parse(input: String): Map<String, Map<String, Int>> {
        return input.lines()
            .associate {
                val bagName = parseBagName(it)
                val containedBags = parseContainedBags(it)

                bagName to containedBags
            }
    }

    private fun parseBagName(line: String): String {
        return line.split(" ").take(2).joinToString(" ")
    }

    private fun parseContainedBags(line: String): Map<String, Int> {
        if (line.contains("no other bags")) {
            return emptyMap()
        }

        return bagPattern.findAll(line)
            .associate { it.groups[2]!!.value to it.groups[1]!!.value.toInt() }
    }
}