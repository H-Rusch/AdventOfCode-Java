package aoc2020.day02

fun interface PasswordRule {

    fun isValid(password: String): Boolean
}