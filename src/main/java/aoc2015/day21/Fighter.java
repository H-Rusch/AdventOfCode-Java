package aoc2015.day21;

import aoc2015.day21.equipment.Equipment;
import java.util.Set;

public class Fighter {

    private final int maxHealth;
    private int health;
    private final int damage;
    private final int armor;

    public Fighter(int health, int damage, int armor) {
        this.maxHealth = health;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public static Fighter createFromEquipment(int health, Set<Equipment> equipment) {
        int damage = equipment.stream().mapToInt(Equipment::damage).sum();
        int armor = equipment.stream().mapToInt(Equipment::armor).sum();

        return new Fighter(health, damage, armor);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public boolean attack(Fighter other) {
        other.takeDamage(damage);

        return other.isDefeated();
    }

    private void takeDamage(int incomingDamage) {
        this.health -= calculateDamageTaken(incomingDamage);
    }

    private int calculateDamageTaken(int incomingDamage) {
        return Math.max(1, incomingDamage - armor);
    }

    public void regenerate() {
        this.health = maxHealth;
    }
}
