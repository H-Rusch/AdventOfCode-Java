package aoc2020.day08

data class ValueInstruction(val instruction: Instruction, val value: Int) {

    companion object {
        private val instructionPattern = Regex("(nop|jmp|acc) ([+\\-]\\d+)")

        fun parse(line: String): ValueInstruction {
            val groups = instructionPattern.find(line)!!.groupValues
            val value = groups[2].toInt()

            val instruction = when (groups[1]) {
                "nop" -> Instruction.NoOp
                "acc" -> Instruction.Acc
                "jmp" -> Instruction.Jmp
                else -> error("No different value possible")
            }

            return ValueInstruction(instruction, value)
        }
    }
}