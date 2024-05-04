package aoc2015.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc2015.day23.instructions.RelativeJumpInstruction;
import org.junit.jupiter.api.Test;

class RelativeJumpInstructionTest {

  @Test
  void returnOffsetOfOne() {
    var instruction = new RelativeJumpInstruction(4);

    assertEquals(4, instruction.getOffset());
  }
}
