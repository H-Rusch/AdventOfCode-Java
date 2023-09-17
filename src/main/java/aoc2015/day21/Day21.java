package aoc2015.day21;

import aoc2015.Day2015;
import aoc2015.day21.equipment.Equipment;

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
        var equipments = shop.calculateAllEquipmentCombinations();
        var boss = parseInput(input);

        return findLowestEquipmentCost(equipments, boss);
    }

    private int findLowestEquipmentCost(List<Set<Equipment>> equipments, Fighter boss) {
        for (Set<Equipment> equipment : equipments) {
            if (fighterWinsWithEquipment(equipment, boss)) {
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

    @Override
    public Object part2(String input) {
        return null;
    }

    private Fighter parseInput(String input) {
        var parts = input.split("\\s");
        return new Fighter(Integer.parseInt(parts[2]), Integer.parseInt(parts[4]), Integer.parseInt(parts[6]));
    }

    public static void main(String[] args) {
        new Day21().main();
    }
}
