package aoc2015.day15;

import java.util.Arrays;
import lombok.Getter;

public class ScoreCalculator {

  private final Ingredient[] ingredients;
  @Getter
  private int maxScore = Integer.MIN_VALUE;

  public ScoreCalculator(Ingredient[] ingredients) {
    this.ingredients = ingredients;
  }

  public int calculateScore(int[] selectedAmounts) {
    int[] properties = new int[4];
    for (int i = 0; i < ingredients.length; i++) {
      if (selectedAmounts[i] == 0) {
        continue;
      }

      addAmountToProperty(ingredients[i], selectedAmounts[i], properties);
    }

    int score = calculateScoreFromProperties(properties);
    maxScore = Math.max(maxScore, score);

    return score;
  }

  private void addAmountToProperty(Ingredient ingredient, int amount, int[] properties) {
    properties[0] += amount * ingredient.capacity();
    properties[1] += amount * ingredient.durability();
    properties[2] += amount * ingredient.flavor();
    properties[3] += amount * ingredient.texture();
  }

  private int calculateScoreFromProperties(int[] properties) {
    if (Arrays.stream(properties).anyMatch(i -> i < 0)) {
      return 0;
    }

    return Arrays.stream(properties).reduce(1, (a, b) -> a * b);
  }
}
