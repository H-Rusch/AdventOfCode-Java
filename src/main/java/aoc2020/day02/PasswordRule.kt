package aoc2020.day02

data class PasswordRule(val position1: Int, val position2: Int, val ch: Char) {

    fun isValid1(password: String): Boolean {
        val count = password.chars().filter { it.toChar() == ch }.count()

        return count in position1..position2
    }

    fun isValid2(password: String): Boolean =
        (password.toCharArray()[position1 - 1] == ch) xor (password.toCharArray()[position2 - 1] == ch)
}