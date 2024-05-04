package aoc2015.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import aoc2015.day23.instructions.IncrementInstruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncrementInstructionTest {

  private Register register;
  private IncrementInstruction instruction;

  @BeforeEach
  public void setUpRegister() {
    register = new Register();
    register.setValue(4);

    instruction = new IncrementInstruction(register);
  }

  @Test
  void IncrementValue() {
    instruction.execute();

    assertEquals(5, register.getValue());
  }

  @Test
  void returnOffsetOfOne() {
    assertEquals(1, instruction.getOffset());
  }
}
