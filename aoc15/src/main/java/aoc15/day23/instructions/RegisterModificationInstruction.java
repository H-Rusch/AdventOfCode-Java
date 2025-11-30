package aoc15.day23.instructions;

import aoc15.day23.Register;

public abstract class RegisterModificationInstruction extends RegisterAccessingInstruction {

  RegisterModificationInstruction(Register register) {
    super(register);
  }

  @Override
  public int getOffset() {
    return 1;
  }
}
