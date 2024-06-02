package aoc2020.day04

import aoc2020.day04.entries.*

class Passport(private val fields: Map<String, PassportEntry>) {

    companion object {
        val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

        fun buildPassport(rawPassport: String): Passport {
            return Passport(collectPassportFields(rawPassport))
        }

        private fun collectPassportFields(rawPassport: String): Map<String, PassportEntry> {
            return rawPassport.split("\\s".toRegex())
                .map { it.split(":") }
                .associate { Pair(it[0], buildPassportEntry(it[0], it[1])) }
        }

        private fun buildPassportEntry(title: String, content: String): PassportEntry {
            return when (title) {
                "byr" -> YearEntry(content, 1920..2002)
                "iyr" -> YearEntry(content, 2010..2020)
                "eyr" -> YearEntry(content, 2020..2030)
                "hgt" -> HeightEntry(content)
                "hcl" -> ColorEntry(content)
                "ecl" -> EyeColorEntry(content)
                "pid" -> IdEntry(content)
                else -> SimpleEntry()
            }
        }
    }

    fun allRequiredFieldsPresent(): Boolean = requiredFields.all { fields.containsKey(it) }

    fun isValid(): Boolean {
        return allRequiredFieldsPresent() &&
                requiredFields.all { fields.getValue(it).isValid() }
    }
}