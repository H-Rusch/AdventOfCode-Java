package day02

class CharCountInRangeRule(
    private val validIndices: ClosedRange<Int>,
    private val ch: Char
) : PasswordRule {

    override fun isValid(password: String): Boolean {
        val count = password.chars().filter { it.toChar() == ch }.count()

        return count in validIndices
    }

    companion object {
        val createPasswordRule: (Int, Int, Char) -> PasswordRule = { value1, value2, ch ->
            CharCountInRangeRule(value1..value2, ch)
        }
    }
}