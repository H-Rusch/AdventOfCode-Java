package aoc15.day15;

import java.util.ArrayList;
import java.util.List;

public class SelectionGenerator {

  private static final int LIMIT = 100;
  private final int numOfElements;
  private final List<int[]> amounts;

  public SelectionGenerator(int numOfElements) {
    this.numOfElements = numOfElements;
    this.amounts = new ArrayList<>();
  }


  public List<int[]> generateSelections() {
    helper(0, new int[numOfElements], 0);

    return amounts;
  }

  private void helper(int elementIndex, int[] currentAmount, int selectedCount) {
    if (selectedCount == LIMIT) {
      amounts.add(currentAmount);
      return;
    }

    for (int i = elementIndex; i < numOfElements; i++) {
      int[] nextAmount = new int[numOfElements];
      System.arraycopy(currentAmount, 0, nextAmount, 0, currentAmount.length);
      nextAmount[i]++;

      helper(i, nextAmount, selectedCount + 1);
    }
  }
}
