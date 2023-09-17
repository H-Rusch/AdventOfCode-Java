package aoc2015.day21;

import aoc2015.day21.equipment.Armor;
import aoc2015.day21.equipment.Equipment;
import aoc2015.day21.equipment.Ring;
import aoc2015.day21.equipment.Weapon;

import java.util.*;

public class ItemShop {

    private List<Weapon> weapons;
    private List<Armor> armors;
    private List<Ring> rings;

    private List<Set<Equipment>> equipmentSelections;

    public ItemShop() {
        initWeapons();
        initArmor();
        initRings();
    }

    public List<Set<Equipment>> generateAllEquipmentCombinations() {
        equipmentSelections = new ArrayList<>();

        generateEquipmentCombinations();

        return equipmentSelections;
    }

    private void generateEquipmentCombinations() {
        equipmentSelections.add(new HashSet<>());

        generateWeapons();
        generateArmor();
        generateRings();
    }

    private void generateWeapons() {
        var newEquipmentSelections = new ArrayList<Set<Equipment>>();

        for (Weapon weapon : weapons) {
            newEquipmentSelections.add(createNewSelectionWithItem(equipmentSelections.get(0), weapon));
        }
        equipmentSelections = newEquipmentSelections;
    }

    private void generateArmor() {
        var newEquipmentSelections = new ArrayList<>(equipmentSelections);

        for (Armor armor : armors) {
            for (Set<Equipment> establishedSelection : equipmentSelections) {
                newEquipmentSelections.add(createNewSelectionWithItem(establishedSelection, armor));
            }
        }
        equipmentSelections = newEquipmentSelections;
    }

    private void generateRings() {
        var newEquipmentSelections = new ArrayList<>(equipmentSelections);
        var ringsList = rings.stream().toList();

        for (Set<Equipment> establishedSelection : equipmentSelections) {
            for (int i = 0; i < ringsList.size(); i++) {
                var newSelection = createNewSelectionWithItem(establishedSelection, rings.get(i));
                newEquipmentSelections.add(newSelection);
                for (int j = i + 1; j < ringsList.size(); j++) {
                    newEquipmentSelections.add(createNewSelectionWithItem(newSelection, ringsList.get(j)));
                }
            }
        }
        equipmentSelections = newEquipmentSelections;
    }

    private Set<Equipment> createNewSelectionWithItem(Set<Equipment> establishedSelection, Equipment toAdd) {
        var newSelection = new HashSet<>(establishedSelection);
        newSelection.add(toAdd);

        return newSelection;
    }

    public static int calculateCostForEquipment(Set<Equipment> equipment) {
        return equipment.stream().mapToInt(Equipment::cost).sum();
    }

    private void initWeapons() {
        weapons = List.of(
                new Weapon(8, 4),
                new Weapon(10, 5),
                new Weapon(25, 6),
                new Weapon(40, 7),
                new Weapon(74, 8)
        );
    }

    private void initArmor() {
        armors = List.of(
                new Armor(13, 1),
                new Armor(31, 2),
                new Armor(53, 3),
                new Armor(75, 4),
                new Armor(102, 5)
        );
    }

    private void initRings() {
        rings = List.of(
                new Ring(25, 1, 0),
                new Ring(50, 2, 0),
                new Ring(100, 3, 0),
                new Ring(20, 0, 1),
                new Ring(40, 0, 2),
                new Ring(80, 0, 3)
        );
    }
}
