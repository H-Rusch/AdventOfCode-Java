package aoc2015.day19;

import aoc2015.Day2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Day19 extends Day2015 {

    public Day19() {
        super(19);
    }

    @Override
    public Object part1(String input) {
        var replacements = parseReplacementDict(input);
        var startingMolecule = parseStartingMolecule(input);

        var moleculeReplacer = new MoleculeReplacer(replacements, startingMolecule);

        return moleculeReplacer.getAllReplacements().size();
    }

    @Override
    public Object part2(String input) {
        return null;
    }

    private Map<String, List<String>> parseReplacementDict(String input) {
        var replacementPart = input.split("\n\n")[0];
        Map<String, List<String>> replacements = new HashMap<>();

        replacementPart.lines().forEach(line -> {
            var parts = line.split(" => ");
            var key = parts[0];
            var value = parts[1];

            replacements.putIfAbsent(key, new ArrayList<>());
            replacements.get(key).add(value);
        });

        return replacements;
    }

    private String parseStartingMolecule(String input) {
        return input.split("\n\n")[1].trim();
    }

    public static void main(String[] args) {
        new Day19().main();
    }
}
