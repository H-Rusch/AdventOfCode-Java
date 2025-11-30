package aoc2015.day23.instructions;

import aoc2015.day23.Register;

public class IncrementInstruction extends RegisterModificationInstruction {

  public IncrementInstruction(Register register) {
    super(register);
  }

  @Override
  public void execute(Register register) {
    register.setValue(register.getValue() + 1);
  }
}
