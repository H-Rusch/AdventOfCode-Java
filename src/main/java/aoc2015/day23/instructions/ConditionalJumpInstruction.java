package aoc2015.day23.instructions;


import aoc2015.day23.Register;

public abstract class ConditionalJumpInstruction extends RegisterModificationInstruction implements
    JumpInstruction {

  ConditionalJumpInstruction(Register register) {
    super(register);
  }
}
