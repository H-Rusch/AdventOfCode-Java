package aoc15.day23.instructions;

import aoc15.day23.Register;

public class JumpIfEvenInstruction extends ConditionalJumpInstruction {

  private final int offsetValue;
  private int currentOffset;

  public JumpIfEvenInstruction(Register register, int offsetValue) {
    super(register);
    this.offsetValue = offsetValue;
  }

  @Override
  public int getOffset() {
    return currentOffset;
  }

  @Override
  void execute(Register register) {
    currentOffset = register.getValue() % 2 == 0 ? offsetValue : 1;
  }
}
