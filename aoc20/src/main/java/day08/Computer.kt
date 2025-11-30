package day08

class Computer(private val instructions: List<ValueInstruction>) {

    private var loopDetector = BooleanArray(instructions.size)

    private var acc = 0
    private var ic = 0


    fun executeProgram(): Result {
        while (ic < instructions.size) {
            if (loopDetector[ic]) {
                return Result(false, acc)
            }
            loopDetector[ic] = true

            val instruction = instructions[ic]
            processInstruction(instruction)
        }

        return Result(true, acc)
    }

    private fun processInstruction(instruction: ValueInstruction) {
        when (instruction.instruction) {
            Instruction.NoOp -> {
                ic++
            }

            Instruction.Acc -> {
                acc += instruction.value
                ic++
            }

            Instruction.Jmp -> {
                ic += instruction.value
            }
        }
    }
}