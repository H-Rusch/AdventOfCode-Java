package aoc15.day15;

public class AmountFilter {

  private static final int GOAL_CALORIES = 500;
  private final Ingredient[] ingredients;

  public AmountFilter(Ingredient[] ingredients) {
    this.ingredients = ingredients;
  }

  public boolean hasGoalCalories(int[] amounts) {
    int calorieSum = 0;
    for (int i = 0; i < amounts.length; i++) {
      calorieSum += amounts[i] * ingredients[i].calories();
    }

    return calorieSum == GOAL_CALORIES;
  }
}
