package aoc2015.day09;

import aoc2015.Day2015;

import java.util.*;

class Day09 extends Day2015 {

    private Map<String, Map<String, Integer>> connections;
    private Set<String> locations;

    public Day09() {
        super(9);
    }

    @Override
    public Integer part1(String input) {
        buildMap(input);

        return findCost(true);
    }

    @Override
    public Integer part2(String input) {
        buildMap(input);

        return findCost(false);
    }

    private Integer findCost(boolean shortest) {
        int result = shortest ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        Queue<State> queue = new ArrayDeque<>();
        for (String startingLocation : locations) {
            queue.offer(new State(startingLocation, 0, new HashSet<>(List.of(startingLocation))));
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.visited.size() == locations.size()) {
                result = shortest ? Math.min(result, state.cost) : Math.max(result, state.cost);
                continue;
            }

            for (String nextLocation : connections.getOrDefault(state.location, new HashMap<>()).keySet()) {
                if (state.visited.contains(nextLocation)) {
                    continue;
                }
                int travelCost = connections.get(state.location).get(nextLocation);
                Set<String> nextVisited = new HashSet<>(state.visited);
                nextVisited.add(nextLocation);

                queue.add(new State(nextLocation, state.cost + travelCost, nextVisited));
            }
        }

        return result;
    }

    private void buildMap(String input) {
        connections = new HashMap<>();
        locations = new HashSet<>();

        for (String s : input.split("\n")) {
            String[] parts = s.split(" ");

            connections.putIfAbsent(parts[0], new HashMap<>());
            connections.get(parts[0]).put(parts[2], Integer.parseInt(parts[4].strip()));
            connections.putIfAbsent(parts[2], new HashMap<>());
            connections.get(parts[2]).put(parts[0], Integer.parseInt(parts[4].strip()));

            locations.add(parts[0]);
            locations.add(parts[2]);
        }
    }

    record State(String location, int cost, Set<String> visited) {
    }

    public static void main(String[] args) {
        new Day09().main();
    }
}
