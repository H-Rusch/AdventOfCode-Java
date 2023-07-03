package aoc2015.day13;

import util.collections.Permutations;

import java.util.List;
import java.util.Map;

class HappinessCalculator {

    private final Map<String, Map<String, Integer>> happinesMap;

    public HappinessCalculator(Map<String, Map<String, Integer>> happinesMap) {
        this.happinesMap = happinesMap;
    }

    public int calculateMaxHappiness() {
        List<List<String>> seatings = new Permutations<String>().permute(happinesMap.keySet());

        return seatings.stream()
                .map(this::calculateHappiness)
                .max(Integer::compareTo)
                .orElseThrow();
    }

    private int calculateHappiness(List<String> seating) {
        int happiness = 0;
        for (int i = 0; i < seating.size(); i++) {
            String current = seating.get(i);
            String left = seating.get(Math.floorMod(i - 1, seating.size()));
            String right = seating.get((i + 1) % seating.size());

            happiness += happinesMap.get(current).get(left);
            happiness += happinesMap.get(current).get(right);
        }

        return happiness;
    }
}
