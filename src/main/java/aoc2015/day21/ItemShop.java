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

    private List<Set<Equipment>> equipmentPossibilities;

    public ItemShop() {
        initWeapons();
        initArmor();
        initRings();
    }

    public List<Set<Equipment>> calculateAllEquipmentCombinations() {
        equipmentPossibilities = new ArrayList<>();

        generateEquipments();
        equipmentPossibilities.sort(Comparator.comparingInt(ItemShop::calculateCostForEquipment));

        return equipmentPossibilities;
    }

    private void generateEquipments() {
        equipmentPossibilities.add(new HashSet<>());

        generateWeapons();
        generateArmor();
        generateRings();
    }

    private void generateWeapons() {
        var newEquipmentPossibilities = new ArrayList<Set<Equipment>>();

        for (Weapon weapon : weapons) {
            newEquipmentPossibilities.add(createNewSelectionWithItem(equipmentPossibilities.get(0), weapon));
        }
        equipmentPossibilities = newEquipmentPossibilities;
    }

    private void generateArmor() {
        var newEquipmentPossibilities = new ArrayList<>(equipmentPossibilities);

        for (Armor armor : armors) {
            for (Set<Equipment> establishedPossibility : equipmentPossibilities) {
                newEquipmentPossibilities.add(createNewSelectionWithItem(establishedPossibility, armor));
            }
        }
        equipmentPossibilities = newEquipmentPossibilities;
    }

    private void generateRings() {
        var newEquipmentPossibilities = new ArrayList<>(equipmentPossibilities);
        var ringsList = rings.stream().toList();

        for (Set<Equipment> establishedPossibility : equipmentPossibilities) {
            for (int i = 0; i < ringsList.size(); i++) {
                var newSelection = createNewSelectionWithItem(establishedPossibility, rings.get(i));
                newEquipmentPossibilities.add(newSelection);
                for (int j = i + 1; j < ringsList.size(); j++) {
                    newEquipmentPossibilities.add(createNewSelectionWithItem(newSelection, ringsList.get(j)));
                }
            }
        }

        equipmentPossibilities = newEquipmentPossibilities;
    }

    private Set<Equipment> createNewSelectionWithItem(Set<Equipment> establishedPossibility, Equipment toAdd) {
        var newSelection = new HashSet<>(establishedPossibility);
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
