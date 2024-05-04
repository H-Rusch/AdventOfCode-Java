package aoc2015.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc2015.day23.instructions.JumpIfEvenInstruction;
import org.junit.jupiter.api.Test;

class JumpIfEvenInstructionTest {

  @Test
  void doNotChangeRegisterValue() {
    var register = new Register();
    register.setValue(4);
    var instruction = new JumpIfEvenInstruction(register, 0);

    instruction.execute();

    assertEquals(4, register.getValue());
  }

  @Test
  void returnJumpOffsetIfRegisterIsEven() {
    var register = new Register();
    register.setValue(4);
    var instruction = new JumpIfEvenInstruction(register, -5);

    instruction.execute();

    assertEquals(-5, instruction.getOffset());
  }

  @Test
  void returnOffsetOfOneIfRegisterIsOdd() {
    var register = new Register();
    register.setValue(5);
    var instruction = new JumpIfEvenInstruction(register, -5);

    instruction.execute();

    assertEquals(1, instruction.getOffset());
  }
}
