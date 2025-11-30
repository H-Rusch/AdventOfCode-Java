package day08

import AbstractDay2020

fun main() {
    Day08().executeParts()
}

class Day08 : AbstractDay2020(8) {

    override fun part1(input: String): Any {
        val instructions = parse(input)
        val computer = Computer(instructions)

        return computer.executeProgram().acc
    }

    override fun part2(input: String): Any {
        val instructions = parse(input).toMutableList()

        for ((index, valueInstruction) in instructions.withIndex()) {
            if (valueInstruction.instruction == Instruction.Acc) {
                continue
            }

            val result = tryReplacementOfInstruction(valueInstruction, instructions, index)
            if (result.terminated) {
                return result.acc
            }
        }

        error("unreachable")
    }

    private fun tryReplacementOfInstruction(
        instruction: ValueInstruction,
        instructions: MutableList<ValueInstruction>,
        index: Int
    ): Result {
        val newInstruction = if (instruction.instruction == Instruction.NoOp) {
            Instruction.Jmp
        } else {
            Instruction.NoOp
        }
        instructions[index] = ValueInstruction(newInstruction, instruction.value)

        val computer = Computer(instructions)
        val result = computer.executeProgram()

        instructions[index] = instruction

        return result
    }
}

private fun parse(input: String): List<ValueInstruction> {
    return input.lines()
        .map { ValueInstruction.parse(it) }
        .toList()
}
