package aoc2015.day21;

import aoc2015.Day2015;
import aoc2015.day21.equipment.Equipment;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Day21 extends Day2015 {

    private static final int HEALTH = 100;

    public Day21() {
        super(21);
    }

    @Override
    public Object part1(String input) {
        var shop = new ItemShop();
        var equipmentSets = shop.generateAllEquipmentCombinations();
        var boss = parseInput(input);

        return findLowestCostingWinningEquipment(equipmentSets, boss);
    }

    @Override
    public Object part2(String input) {
        var shop = new ItemShop();
        var equipmentSets = shop.generateAllEquipmentCombinations();
        var boss = parseInput(input);

        return findHighestCostingLosingEquipment(equipmentSets, boss);
    }

    private int findLowestCostingWinningEquipment(List<Set<Equipment>> equipments, Fighter boss) {
        equipments.sort(Comparator.comparingInt(ItemShop::calculateCostForEquipment));

        for (Set<Equipment> equipment : equipments) {
            if (fighterWinsWithEquipment(equipment, boss)) {
                return ItemShop.calculateCostForEquipment(equipment);
            }
        }

        throw new RuntimeException("No Equipment can beat the boss. All hope is lost.");
    }

    private int findHighestCostingLosingEquipment(List<Set<Equipment>> equipments, Fighter boss) {
        equipments.sort(Comparator.comparingInt(ItemShop::calculateCostForEquipment).reversed());

        for (Set<Equipment> equipment : equipments) {
            if (!fighterWinsWithEquipment(equipment, boss)) {
                return ItemShop.calculateCostForEquipment(equipment);
            }
        }

        throw new RuntimeException("No Equipment can beat the boss. All hope is lost.");
    }

    private boolean fighterWinsWithEquipment(Set<Equipment> equipment, Fighter boss) {
        Fighter hero = Fighter.createFromEquipment(HEALTH, equipment);
        boss.regenerate();

        return fight(hero, boss);
    }

    protected boolean fight(Fighter hero, Fighter boss) {
        while (true) {
            if (hero.attack(boss)) return true;
            if (boss.attack(hero)) return false;
        }
    }

    private Fighter parseInput(String input) {
        var parts = input.split("\\s");
        return new Fighter(Integer.parseInt(parts[2]), Integer.parseInt(parts[4]), Integer.parseInt(parts[6]));
    }

    public static void main(String[] args) {
        new Day21().main();
    }
}
