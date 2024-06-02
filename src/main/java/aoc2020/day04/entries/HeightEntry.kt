package aoc2020.day04.entries

class HeightEntry(private val content: String) : PassportEntry {

    companion object {
        private val HEIGHT_PATTERN = Regex("(\\d+)(cm|in)")
        private val CM_RANGE = 150..193
        private val IN_RANGE = 59..76
    }

    override fun isValid(): Boolean {
        val groups = HEIGHT_PATTERN.find(content)?.groups

        val number = groups?.get(1)?.value?.toInt()
        val unit = groups?.get(2)?.value.toString()

        return if (unit == "cm") {
            CM_RANGE.contains(number)
        } else {
            IN_RANGE.contains(number)
        }
    }
}
