package aoc2020.day04.entries

class IdEntry(private val content: String) : PassportEntry {

    companion object {
        private val ID_PATTERN = Regex("^\\d{9}$")
    }

    override fun isValid(): Boolean = content.matches(ID_PATTERN)
}