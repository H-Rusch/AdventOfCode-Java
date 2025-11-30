package day02

fun interface PasswordRule {

    fun isValid(password: String): Boolean
}