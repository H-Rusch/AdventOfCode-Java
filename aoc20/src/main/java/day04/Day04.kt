package day04

import AbstractDay2020

fun main() {
    Day04().executeParts()
}

class Day04 : AbstractDay2020(4) {

    override fun part1(input: String): Any {
        return parse(input).count { it.allRequiredFieldsPresent() }
    }

    override fun part2(input: String): Any {
        return parse(input).count { it.isValid() }
    }

    private fun parse(input: String): List<Passport> {
        return input.split("\n\n")
            .map { Passport.buildPassport(it) }
            .toList()
    }
}