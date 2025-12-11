package day06

abstract class Calculation(val numbers: List<Int>) {

    abstract fun calculate(): Long
}

class AddingCalculation(numbers: List<Int>) : Calculation(numbers) {
    override fun calculate(): Long = numbers.sumOf { it.toLong() }
}

class MultiplyingCalculation(numbers: List<Int>) : Calculation(numbers) {
    override fun calculate(): Long = numbers.map { it.toLong() }.reduce { v1, v2 -> v1 * v2 }
}
