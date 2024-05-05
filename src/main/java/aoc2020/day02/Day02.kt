package aoc2020.day02

import aoc2020.AbstractDay2020
import util.regex.RegexHelper
import java.util.regex.Pattern

fun main() {
    Day02().executeParts()
}

class Day02 : AbstractDay2020(2) {

    private val passwordRulePattern: Pattern = Pattern.compile("^(\\d+)-(\\d+) ([a-z])$")

    override fun part1(input: String): Any = parse(input).count { it.first.isValid1(it.second) }

    override fun part2(input: String): Any = parse(input).count { it.first.isValid2(it.second) }

    private fun parse(input: String): List<Pair<PasswordRule, String>> {
        return input.lines().map {
            val parts = it.split(": ")
            val groups = RegexHelper.getGroups(passwordRulePattern.matcher(parts[0]))

            val passwordRule = PasswordRule(
                groups[1].toInt(),
                groups[2].toInt(),
                groups[3].toCharArray()[0]
            )

            Pair(passwordRule, parts[1])
        }.toList()
    }
}