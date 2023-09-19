package aoc2015.day23;

import aoc2015.day23.instructions.HalfInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HalfInstructionTest {

    private Register register;
    private HalfInstruction instruction;

    @BeforeEach
    public void setUpRegister() {
        register = new Register();
        register.setValue(4);

        instruction = new HalfInstruction(register);
    }

    @Test
    void halvingEvenValue() {
        instruction.execute();

        assertEquals(2, register.getValue());
    }

    @Test
    void halvingOddValue() {
        register.setValue(5);

        instruction.execute();

        assertEquals(2, register.getValue());
    }

    @Test
    void returnOffsetOfOne() {
        assertEquals(1, instruction.getOffset());
    }
}
