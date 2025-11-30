package aoc15.day23.instructions;

import aoc15.day23.Register;

public class IncrementInstruction extends RegisterModificationInstruction {

  public IncrementInstruction(Register register) {
    super(register);
  }

  @Override
  public void execute(Register register) {
    register.setValue(register.getValue() + 1);
  }
}
