package util.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {

    /** Return r length subsequences of elements from the input. */
    public static List<List<Integer>> combinations(List<Integer> values, int r) {
        if (r <= 0 || values.isEmpty()) return Collections.emptyList();

        List<List<Integer>> combinations = new ArrayList<>();

        fillCombinations(combinations, values, new ArrayList<>(), r, 0);

        return combinations;
    }

    private static void fillCombinations(List<List<Integer>> combinations, List<Integer> values, List<Integer> tmp, int r, int startIndex) {
        if (tmp.size() == r) {
            combinations.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = startIndex; i < values.size(); i++) {
            tmp.add(values.get(i));
            fillCombinations(combinations, values, tmp, r, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
