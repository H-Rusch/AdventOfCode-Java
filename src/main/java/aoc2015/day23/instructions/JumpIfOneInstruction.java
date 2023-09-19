package aoc2015.day23.instructions;

import aoc2015.day23.Register;

public class JumpIfOneInstruction extends ConditionalJumpInstruction {

    private final int offsetValue;
    private int currentOffset;

    public JumpIfOneInstruction(Register register, int offsetValue) {
        super(register);
        this.offsetValue = offsetValue;
    }

    @Override
    public int getOffset() {
        return currentOffset;
    }

    @Override
    void execute(Register register) {
        currentOffset = register.getValue() == 1 ? offsetValue : 1;
    }
}
