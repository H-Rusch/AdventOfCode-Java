package aoc2015.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc2015.day23.instructions.TripleInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripleInstructionTest {

  private Register register;
  private TripleInstruction instruction;

  @BeforeEach
  public void setUpRegister() {
    register = new Register();
    register.setValue(4);

    instruction = new TripleInstruction(register);
  }

  @Test
  void tripleValue() {
    instruction.execute();

    assertEquals(12, register.getValue());
  }

  @Test
  void returnOffsetOfOne() {
    assertEquals(1, instruction.getOffset());
  }
}
