package aoc15.day22;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;

public class FightState {

  private static final int MIN_DAMAGE = 1;

  private final boolean hardMode;

  @Getter
  private int totalManaSpent;

  private int playerHealth;
  private int playerMana;

  private int bossHealth;
  private final int bossDamage;

  private Set<Effect> activeEffects;

  public FightState(boolean hardMode, int totalManaSpent, int playerHealth, int playerMana,
      int bossHealth, int bossDamage, Set<Effect> activeEffects) {
    this.hardMode = hardMode;
    this.totalManaSpent = totalManaSpent;
    this.playerHealth = playerHealth;
    this.playerMana = playerMana;
    this.bossHealth = bossHealth;
    this.bossDamage = bossDamage;
    this.activeEffects = activeEffects;
  }

  public List<FightState> getNextStates() {
    List<Spell> castableSpells = SpellSelection.castableSpells(playerMana, activeEffects);

    return castableSpells.stream().map(this::getNextStateForSpell).toList();
  }

  private FightState getNextStateForSpell(Spell spell) {
    var fightCopy = this.copy();

    fightCopy.playerTurn(spell);

    if (!fightCopy.fightFinished()) {
      fightCopy.bossTurn();
    }

    return fightCopy;
  }

  private void playerTurn(Spell spell) {
    hardModeDamage();
    if (fightFinished()) {
      return;
    }

    executeEffects();

    if (!bossAlive()) {
      return;
    }

    castSpell(spell);
  }

  private void hardModeDamage() {
    if (!hardMode) {
      return;
    }
    playerHealth--;
  }

  private void executeEffects() {
    activeEffects.forEach(this::executeEffect);
    filterActiveEffects();
  }

  private void executeEffect(Effect effect) {
    var type = effect.getType();
    switch (type) {
      case SHIELD -> { /* no op */ }
      case POISON -> bossHealth -= type.getDamage();
      case RECHARGE -> playerMana += type.getManaRestoration();
      default -> throw new IllegalStateException("Effect type not supported " + type);
    }

    effect.tick();
  }

  private void filterActiveEffects() {
    activeEffects = activeEffects.stream()
        .filter(Effect::isActive)
        .collect(Collectors.toSet());
  }

  private void castSpell(Spell spell) {
    var effect = spell.effect();
    if (effect != null) {
      activeEffects.add(effect.copy());
    }

    spellCalculation(spell);
  }

  private void spellCalculation(Spell spell) {
    bossHealth -= spell.damage();
    playerHealth += spell.heal();

    playerMana -= spell.cost();
    totalManaSpent += spell.cost();
  }

  private void bossTurn() {
    executeEffects();

    if (!bossAlive()) {
      return;
    }

    damagePlayer();
  }

  private void damagePlayer() {
    playerHealth -= Math.max(MIN_DAMAGE, bossDamage - calculatePlayerArmor());
  }

  private int calculatePlayerArmor() {
    return activeEffects.stream().mapToInt(e -> e.getType().getArmor()).sum();
  }

  public boolean playerWon() {
    return playerAlive() && !bossAlive();
  }

  public boolean bossWon() {
    return !playerAlive() && bossAlive();
  }

  private boolean fightFinished() {
    return playerWon() || bossWon();
  }

  private boolean playerAlive() {
    return playerHealth > 0;
  }

  private boolean bossAlive() {
    return bossHealth > 0;
  }

  private FightState copy() {
    Set<Effect> activeEffectsCopy = activeEffects.stream().map(Effect::copy)
        .collect(Collectors.toSet());

    return new FightState(hardMode, totalManaSpent, playerHealth, playerMana, bossHealth,
        bossDamage, activeEffectsCopy);
  }
}
