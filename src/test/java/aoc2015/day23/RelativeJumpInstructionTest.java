package aoc2015.day23;

import aoc2015.day23.instructions.RelativeJumpInstruction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RelativeJumpInstructionTest {

    @Test
    void returnOffsetOfOne() {
        var instruction = new RelativeJumpInstruction(4);

        assertEquals(4, instruction.getOffset());
    }
}
