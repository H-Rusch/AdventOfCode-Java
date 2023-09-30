package aoc2015.day19;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MedicineReducer {

    private final String goal;
    private String medicine;
    private int steps;
    private final MoleculeReplacer replacer;

    public MedicineReducer(String goal, String startingMedicine, Map<String, List<String>> replacementRules) {
        this.goal = goal;
        this.medicine = startingMedicine;
        this.steps = 0;
        this.replacer = new MoleculeReplacer(replacementRules);
    }

    public int reduceMedicineToGoal() {
        while (!medicine.equals(goal)) {
            var replacements = replacer.getAllReplacements(medicine);
            medicine = replacements.stream().min(Comparator.comparingInt(String::length)).orElseThrow();
            steps++;
        }

        return steps;
    }
}
