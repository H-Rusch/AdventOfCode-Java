package aoc2015.day17;

import lombok.Getter;

import java.util.List;

public class CombinationCounter {

    private final int limit;
    private final List<Integer> containers;

    @Getter
    private int count = 0;

    public CombinationCounter(int limit, List<Integer> containers) {
        this.limit = limit;
        this.containers = containers;
    }

    public int generateCombinations() {
        helper(0, 0);

        return count;
    }

    private void helper(int index, int liters) {
        if (liters == limit) {
            count++;
            return;
        }

        for (int i = index; i < containers.size(); i++) {
            int newLiters = liters + containers.get(i);
            if (newLiters <= limit) {
                helper(i + 1, newLiters);
            }
        }
    }
}
