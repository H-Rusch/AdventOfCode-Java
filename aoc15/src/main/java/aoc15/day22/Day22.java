package aoc15.day22;

import aoc15.AbstractDay2015;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

import kotlin.Pair;
import lombok.NonNull;

public class Day22 extends AbstractDay2015 {

  private static final int PLAYER_STARTING_HEALTH = 50;
  private static final int PLAYER_STARTING_MANA = 500;

  public Day22() {
    super(22);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var pair = parseInput(input);
    var fight = createNormalFight(pair.getFirst(), pair.getSecond());

    return getMinimumWinningMana(fight);
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var pair = parseInput(input);
    var fight = createHardFight(pair.getFirst(), pair.getSecond());

    return getMinimumWinningMana(fight);
  }

  private Pair<Integer, Integer> parseInput(@NonNull String input) {
    var numbers = input.lines().map(line -> {
      var parts = Arrays.stream(line.split(" ")).toArray(String[]::new);
      var last = parts[parts.length - 1];

      return Integer.parseInt(last);
    }).toList();

    return new Pair<>(numbers.get(0), numbers.get(1));
  }

  private FightState createNormalFight(int bossHealth, int bossDamage) {
    return new FightState(false, 0, PLAYER_STARTING_HEALTH, PLAYER_STARTING_MANA, bossHealth,
        bossDamage, new HashSet<>());
  }

  private FightState createHardFight(int bossHealth, int bossDamage) {
    return new FightState(true, 0, PLAYER_STARTING_HEALTH, PLAYER_STARTING_MANA, bossHealth,
        bossDamage, new HashSet<>());
  }

  private int getMinimumWinningMana(FightState initialFight) {
    Queue<FightState> fights = new PriorityQueue<>(
        Comparator.comparingInt(FightState::getTotalManaSpent));
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
    new Day22().executeParts();
  }
}
