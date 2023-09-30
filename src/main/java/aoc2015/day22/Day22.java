package aoc2015.day22;

import aoc2015.Day2015;
import util.collections.Pair;

import java.util.*;

public class Day22 extends Day2015 {

    private static final int PLAYER_STARTING_HEALTH = 50;
    private static final int PLAYER_STARTING_MANA = 500;

    public Day22() {
        super(22);
    }

    @Override
    public Object part1(String input) {
        var pair = parseInput(input);
        var fight = createNormalFight(pair.one(), pair.two());

        return getMinimumWinningMana(fight);
    }

    @Override
    public Object part2(String input) {
        var pair = parseInput(input);
        var fight = createHardFight(pair.one(), pair.two());

        return getMinimumWinningMana(fight);
    }

    private Pair<Integer, Integer> parseInput(String input) {
        var numbers = input.lines().map(line -> {
            var parts = Arrays.stream(line.split(" ")).toArray(String[]::new);
            var last = parts[parts.length - 1];

            return Integer.parseInt(last);
        }).toList();

        return new Pair<>(numbers.get(0), numbers.get(1));
    }

    private FightState createNormalFight(int bossHealth, int bossDamage) {
        return new FightState(false, 0, PLAYER_STARTING_HEALTH, PLAYER_STARTING_MANA, bossHealth, bossDamage, new HashSet<>());
    }

    private FightState createHardFight(int bossHealth, int bossDamage) {
        return new FightState(true, 0, PLAYER_STARTING_HEALTH, PLAYER_STARTING_MANA, bossHealth, bossDamage, new HashSet<>());
    }

    private int getMinimumWinningMana(FightState initialFight) {
        Queue<FightState> fights = new PriorityQueue<>(Comparator.comparingInt(FightState::getTotalManaSpent));
        fights.offer(initialFight);

        while (!fights.isEmpty()) {
            var fight = fights.poll();

            if (fight.playerWon()) {
                return fight.getTotalManaSpent();
            }
            if (fight.bossWon()) {
                continue;
            }

            for (FightState nextState : fight.getNextStates()) {
                fights.offer(nextState);
            }
        }

        throw new RuntimeException("No winning fight found");
    }

    public static void main(String[] args) {
        new Day22().main();
    }
}
