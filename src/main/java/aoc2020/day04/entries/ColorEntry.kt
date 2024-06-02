package aoc2020.day04.entries

class ColorEntry(private val content: String) : PassportEntry {

    companion object {
        val COLOR_PATTERN = Regex("^#[0-9a-f]{6}$")
    }

    override fun isValid(): Boolean = content.matches(COLOR_PATTERN)
}