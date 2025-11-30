package aoc15.day23;

import aoc15.AbstractDay2015;
import lombok.NonNull;

public class Day23 extends AbstractDay2015 {

  public Day23() {
    super(23);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var programParser = new ProgramParser(input);
    var computer = new Computer(programParser.getRegisterA(), programParser.getRegisterB(),
        programParser.getProgram());
    computer.executeProgram();

    return computer.getRegisterBValue();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var programParser = new ProgramParser(input);
    var computer = new Computer(programParser.getRegisterA(), programParser.getRegisterB(),
        programParser.getProgram());
    computer.setRegisterA(1);
    computer.executeProgram();

    return computer.getRegisterBValue();
  }

  public static void main(String[] args) {
    new Day23().executeParts();
  }
}
