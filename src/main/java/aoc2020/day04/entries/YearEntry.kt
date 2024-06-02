package aoc2020.day04.entries

import java.util.*

class YearEntry(
    private val content: String,
    private val acceptedRange: ClosedRange<Int>
) : PassportEntry {

    override fun isValid(): Boolean {
        return convertToInt(content)
            .map { acceptedRange.contains(it) }
            .orElse(false)
    }

    private fun convertToInt(string: String): Optional<Int> {
        return Optional.ofNullable(string.toIntOrNull())
    }
}