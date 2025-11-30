package aoc15.day23.instructions;

import aoc15.day23.Register;

public class TripleInstruction extends RegisterModificationInstruction {

  public TripleInstruction(Register register) {
    super(register);
  }

  @Override
  public void execute(Register register) {
    register.setValue(register.getValue() * 3);
  }
}
