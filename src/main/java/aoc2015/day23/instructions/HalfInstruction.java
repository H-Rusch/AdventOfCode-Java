package aoc2015.day23.instructions;

import aoc2015.day23.Register;

public class HalfInstruction extends RegisterModificationInstruction {

    public HalfInstruction(Register register) {
        super(register);
    }

    @Override
    public void execute(Register register) {
        register.setValue(register.getValue() / 2);
    }
}
