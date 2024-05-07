package aoc2020.day02

class OneCharAtIndexRule(
    private val index1: Int,
    private val index2: Int,
    private val ch: Char
) : PasswordRule {

    override fun isValid(password: String): Boolean =
        (password.toCharArray()[index1 - 1] == ch) xor (password.toCharArray()[index2 - 1] == ch)

    companion object {
        val createPasswordRule: (Int, Int, Char) -> PasswordRule = { value1, value2, ch ->
            OneCharAtIndexRule(value1, value2, ch)
        }
    }
}