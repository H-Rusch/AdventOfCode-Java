package util.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations<T> {

  public List<List<T>> permute(Set<T> values) {
    return permute(new ArrayList<>(values));
  }

  public List<List<T>> permute(List<T> values) {
    List<List<T>> permutations = new ArrayList<>();
    Set<T> valueSet = new HashSet<>(values);
    generatePermutations(permutations, new ArrayList<>(), valueSet);

    return permutations;
  }

  private void generatePermutations(List<List<T>> permutations, List<T> current, Set<T> remaining) {
    if (!remaining.isEmpty()) {
      for (T n : remaining) {
        List<T> newPermutation = new ArrayList<>(current);
        newPermutation.add(n);

        Set<T> newRemaining = new HashSet<>(remaining);
        newRemaining.remove(n);

        generatePermutations(permutations, newPermutation, newRemaining);
      }
    } else {
      permutations.add(current);
    }
  }
}
