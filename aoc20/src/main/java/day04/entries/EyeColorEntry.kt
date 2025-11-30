package day04.entries

class EyeColorEntry(private val content: String) : PassportEntry {

    companion object {
        private val VALID_VALUES = Regex("(amb|blu|brn|gry|grn|hzl|oth)")
    }

    override fun isValid(): Boolean = content.matches(VALID_VALUES)
}