package aoc2015.day23.instructions;

import aoc2015.day23.Register;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RegisterAccessingInstruction implements Instruction {

  private Register register;

  @Override
  public void execute() {
    this.execute(register);
  }

  abstract void execute(Register register);
}
