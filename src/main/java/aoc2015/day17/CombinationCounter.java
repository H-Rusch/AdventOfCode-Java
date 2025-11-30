package aoc2015.day17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationCounter {

  private final int limit;
  private final List<Integer> containers;
  // tracks how many combinations there are to reach the limit with <key> number of containers
  private final Map<Integer, Integer> reachingLimitMap;

  private int combinationCount = 0;

  public CombinationCounter(int limit, List<Integer> containers) {
    this.limit = limit;
    this.containers = containers;
    this.reachingLimitMap = new HashMap<>();
  }

  public int generateCombinations() {
    helper(0, 0, 0);

    return combinationCount;
  }

  private void helper(int index, int liters, int containerCount) {
    if (liters == limit) {
      combinationCount++;
      incrementContainerCount(containerCount);
      return;
    }

    for (int i = index; i < containers.size(); i++) {
      int newLiters = liters + containers.get(i);
      if (newLiters <= limit) {
        helper(i + 1, newLiters, containerCount + 1);
      }
    }
  }

  private void incrementContainerCount(int containerCount) {
    reachingLimitMap.putIfAbsent(containerCount, 0);
    reachingLimitMap.put(containerCount, reachingLimitMap.get(containerCount) + 1);
  }

  public int differentWaysWithMinContainers() {
    return reachingLimitMap.get(minContainers());
  }

  private int minContainers() {
    return reachingLimitMap.keySet().stream().min(Integer::compareTo).orElseThrow();
  }
}
