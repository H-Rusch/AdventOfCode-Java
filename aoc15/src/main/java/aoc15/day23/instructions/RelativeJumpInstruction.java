package aoc15.day23.instructions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RelativeJumpInstruction implements JumpInstruction {

  private int offset;

  @Override
  public void execute() {
    // no operation
  }
}
