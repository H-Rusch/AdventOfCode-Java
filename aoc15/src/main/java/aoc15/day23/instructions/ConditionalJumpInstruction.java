package aoc15.day23.instructions;


import aoc15.day23.Register;

public abstract class ConditionalJumpInstruction extends RegisterModificationInstruction implements
    JumpInstruction {

  ConditionalJumpInstruction(Register register) {
    super(register);
  }
}
