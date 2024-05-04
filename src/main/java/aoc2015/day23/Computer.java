package aoc2015.day23;

import aoc2015.day23.instructions.Instruction;
import java.util.List;
import java.util.Optional;

public class Computer {

    private final Register registerA;
    private final Register registerB;

    private int instructionCounter;
    private final List<Instruction> program;

    private boolean halted;

    public Computer(Register registerA, Register registerB, List<Instruction> program) {
        this.program = program;
        this.registerA = registerA;
        this.registerB = registerB;

        this.instructionCounter = 0;
        this.halted = false;
    }

    public void executeProgram() {
        while (!this.halted) {
            executeInstruction();
        }
    }

    private void executeInstruction() {
        var optionalInstruction = loadInstruction();
        if (optionalInstruction.isEmpty()) {
            return;
        }

        var instruction = optionalInstruction.get();
        instruction.execute();

        adjustInstructionCounter(instruction);
    }

    private Optional<Instruction> loadInstruction() {
        if (instructionCounter >= program.size()) {
            this.halted = true;
            return Optional.empty();
        }

        return Optional.of(program.get(instructionCounter));
    }

    private void adjustInstructionCounter(Instruction instruction) {
        instructionCounter += instruction.getOffset();
    }

    public long getRegisterBValue() {
        return registerB.getValue();
    }

    public void setRegisterA(int value) {
        registerA.setValue(value);
    }
}
