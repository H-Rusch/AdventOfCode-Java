package aoc15.day23;

import aoc15.day23.instructions.HalfInstruction;
import aoc15.day23.instructions.IncrementInstruction;
import aoc15.day23.instructions.Instruction;
import aoc15.day23.instructions.JumpIfEvenInstruction;
import aoc15.day23.instructions.JumpIfOneInstruction;
import aoc15.day23.instructions.RelativeJumpInstruction;
import aoc15.day23.instructions.TripleInstruction;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ProgramParser {

  private final Register registerA;
  private final Register registerB;
  private List<Instruction> program;

  public ProgramParser(String input) {
    this.registerA = new Register();
    this.registerB = new Register();
    this.program = new ArrayList<>();

    parseInput(input);
  }

  public void parseInput(String input) {
    this.program = input.lines()
        .map(this::createInstruction)
        .toList();
  }

  private Instruction createInstruction(String line) {
    return createInstruction(line.split(",? "));
  }

  private Instruction createInstruction(String[] parts) {
    return switch (parts[0]) {
      case ("hlf") -> new HalfInstruction(getRegisterForLetter(parts[1]));
      case ("tpl") -> new TripleInstruction(getRegisterForLetter(parts[1]));
      case ("inc") -> new IncrementInstruction(getRegisterForLetter(parts[1]));
      case ("jmp") -> new RelativeJumpInstruction(Integer.parseInt(parts[1]));
      case ("jie") ->
          new JumpIfEvenInstruction(getRegisterForLetter(parts[1]), Integer.parseInt(parts[2]));
      case ("jio") ->
          new JumpIfOneInstruction(getRegisterForLetter(parts[1]), Integer.parseInt(parts[2]));
      default -> throw new RuntimeException("Unknown instruction: " + parts[0]);
    };
  }

  private Register getRegisterForLetter(String letter) {
    return switch (letter) {
      case ("a") -> registerA;
      case ("b") -> registerB;
      default -> throw new RuntimeException("No matching register for letter: " + letter);
    };
  }
}
