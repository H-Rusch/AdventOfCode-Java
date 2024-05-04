package aoc2015.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc2015.day23.instructions.JumpIfEvenInstruction;
import aoc2015.day23.instructions.JumpIfOneInstruction;
import org.junit.jupiter.api.Test;

class JumpIfOneInstructionTest {

  @Test
  void doNotChangeRegisterValue() {
    var register = new Register();
    register.setValue(4);
    var instruction = new JumpIfOneInstruction(register, 0);

    instruction.execute();

    assertEquals(4, register.getValue());
  }

  @Test
  void returnJumpOffsetIfRegisterIsOne() {
    var register = new Register();
    register.setValue(1);
    var instruction = new JumpIfOneInstruction(register, -5);

    instruction.execute();

    assertEquals(-5, instruction.getOffset());
  }

  @Test
  void returnOffsetOfOneIfRegisterIsNotOne() {
    var register = new Register();
    register.setValue(5);
    var instruction = new JumpIfEvenInstruction(register, -5);

    instruction.execute();

    assertEquals(1, instruction.getOffset());
  }
}
