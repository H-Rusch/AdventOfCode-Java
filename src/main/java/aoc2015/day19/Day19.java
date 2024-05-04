package aoc2015.day19;

import aoc2015.AbstractDay2015;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

public class Day19 extends AbstractDay2015 {

  private static final String GOAL = "e";

  public Day19() {
    super(19);
  }

  @NonNull
  @Override
  public Object part1(@NonNull String input) {
    var replacements = parseReplacementDict(input);
    var startingMolecule = parseStartingMolecule(input);

    var moleculeReplacer = new MoleculeReplacer(replacements);

    return moleculeReplacer.getAllReplacements(startingMolecule).size();
  }

  @NonNull
  @Override
  public Object part2(@NonNull String input) {
    var startingMolecule = parseStartingMolecule(input);
    var replacements = parseReplacementDict(input);
    replacements = reverseReplacementDict(replacements);

    var reducer = new MedicineReducer(GOAL, startingMolecule, replacements);

    return reducer.reduceMedicineToGoal();
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

  private Map<String, List<String>> reverseReplacementDict(Map<String, List<String>> replacements) {
    Map<String, List<String>> newReplacements = new HashMap<>();

    replacements.forEach((key, values) -> values.forEach(value -> {
      newReplacements.putIfAbsent(value, new ArrayList<>());
      newReplacements.get(value).add(key);
    }));

    return newReplacements;
  }

  private String parseStartingMolecule(String input) {
    return input.split("\n\n")[1].trim();
  }

  public static void main(String[] args) {
    new Day19().executeParts();
  }
}
