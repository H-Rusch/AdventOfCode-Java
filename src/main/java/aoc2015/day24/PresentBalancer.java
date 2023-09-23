package aoc2015.day24;

import util.collections.CombinationUtil;

import java.util.*;

public class PresentBalancer {

    private final int groupCount;

    private final List<Integer> allPresents;
    private final int balancedWeight;

    private final Map<Integer, List<List<Integer>>> weightGroups;

    public PresentBalancer(List<Integer> presents, int groupCount) {
        this.groupCount = groupCount;
        this.allPresents = presents;
        this.balancedWeight = calculateBalancedWeight();
        this.weightGroups = new HashMap<>();
    }

    public long findFirstGroupsEntanglement() {
        int comboLength = 1;
        var combinationUtil = new CombinationUtil<>(allPresents);
        while (!weightGroups.containsKey(balancedWeight)) {
            combinationUtil.combinations(comboLength).forEach(this::addCombinationToMap);
            comboLength++;
        }

        return selectSmallestQuantumEntanglement();
    }

    private int calculateBalancedWeight() {
        return sumPresentWeights(allPresents) / groupCount;
    }

    private int sumPresentWeights(List<Integer> presents) {
        return presents.stream().mapToInt(Integer::intValue).sum();
    }

    private void addCombinationToMap(List<Integer> combination) {
        var weight = sumPresentWeights(combination);

        weightGroups.computeIfAbsent(weight, k -> new ArrayList<>());

        weightGroups.get(weight).add(combination);
    }

    private long selectSmallestQuantumEntanglement() {
        var smallestSize = weightGroups.get(balancedWeight).stream().mapToInt(List::size).min().orElseThrow();

        return weightGroups.get(balancedWeight).stream()
                .filter(list -> list.size() == smallestSize)
                .map(this::calculateQuantumEntanglement)
                .min(Long::compareTo)
                .orElseThrow();
    }

    private long calculateQuantumEntanglement(List<Integer> presents) {
        return presents.stream()
                .mapToLong(Long::valueOf)
                .reduce((i1, i2) -> i1 * i2)
                .orElseThrow();
    }
}
