package aoc2015.day23;

import aoc2015.Day2015;

public class Day23 extends Day2015 {

    public Day23() {
        super(23);
    }

    @Override
    public Object part1(String input) {
        var programParser = new ProgramParser(input);
        var computer = new Computer(programParser.getRegisterA(), programParser.getRegisterB(), programParser.getProgram());
        computer.executeProgram();

        return computer.getRegisterBValue();
    }

    @Override
    public Object part2(String input) {
        var programParser = new ProgramParser(input);
        var computer = new Computer(programParser.getRegisterA(), programParser.getRegisterB(), programParser.getProgram());
        computer.setRegisterA(1);
        computer.executeProgram();

        return computer.getRegisterBValue();
    }

    public static void main(String[] args) {
        new Day23().main();
    }
}
