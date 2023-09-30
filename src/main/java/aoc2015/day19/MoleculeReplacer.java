package aoc2015.day19;

import java.util.*;

public class MoleculeReplacer {

    private final Map<String, List<String>> replacementRules;
    private final String startingMolecule;

    private final Set<String> replacements = new HashSet<>();

    public MoleculeReplacer(Map<String, List<String>> replacementRules, String startingMolecule) {
        this.replacementRules = replacementRules;
        this.startingMolecule = startingMolecule;
    }

    public Set<String> getAllReplacements() {
        fillReplacements();

        return replacements;
    }

    private void fillReplacements() {
        replacementRules.forEach((key, replacementOptions) -> replacementOptions.forEach(replacementOption -> {
            var newReplacements = collectOneReplacementResults(key, replacementOption);
            replacements.addAll(newReplacements);
        }));
    }

    private Set<String> collectOneReplacementResults(String searchFor, String replaceWith) {
        Set<String> newReplacements = new HashSet<>();
        var keyLength = searchFor.length();

        for (int i = 0; i < startingMolecule.length() - keyLength + 1; i++) {
            var current = startingMolecule.substring(i, i + keyLength);

            if (current.equals(searchFor)) {
                newReplacements.add(performReplacement(i, keyLength, replaceWith));
            }
        }

        return newReplacements;
    }

    private String performReplacement(int index, int keyLength, String replaceWith) {
        var left = startingMolecule.substring(0, index);
        var right = startingMolecule.substring(index + keyLength);

        return left + replaceWith + right;
    }
}
