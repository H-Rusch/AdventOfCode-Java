package util.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationUtil<T> {

  private final List<T> values;
  private List<List<T>> combinations;

  public CombinationUtil(List<T> values) {
    this.values = values;
  }

  /**
   * Return r length subsequences of elements from the input.
   */
  public List<List<T>> combinations(int r) {
      if (r <= 0 || values.isEmpty()) {
          return Collections.emptyList();
      }

    combinations = new ArrayList<>();

    fillCombinations(new ArrayList<>(), r, 0);

    return combinations;
  }

  private void fillCombinations(List<T> tmp, int r, int startIndex) {
    if (tmp.size() == r) {
      combinations.add(new ArrayList<>(tmp));
      return;
    }

    for (int i = startIndex; i < values.size(); i++) {
      tmp.add(values.get(i));
      fillCombinations(tmp, r, i + 1);
      tmp.remove(tmp.size() - 1);
    }
  }
}
