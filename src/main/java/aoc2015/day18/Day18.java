package aoc2015.day18;

import aoc2015.AbstractDay2015;
import lombok.NonNull;

public class Day18 extends AbstractDay2015 {

  private static final int STEPS = 100;

  public Day18() {
    super(18);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var lightGrid = new LightGrid(input, false);

    lightGrid.simulation(STEPS);

    return lightGrid.countLitLights();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var lightGrid = new LightGrid(input, true);

    lightGrid.simulation(STEPS);

    return lightGrid.countLitLights();
  }

  public static void main(String[] args) {
    new Day18().executeParts();
  }
}
