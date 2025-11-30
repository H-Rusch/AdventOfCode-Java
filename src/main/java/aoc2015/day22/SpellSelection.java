package aoc2015.day22;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpellSelection {

  private SpellSelection() {
  }

  static final List<Spell> SPELLS = List.of(
      new Spell("Magic Missile", 53, 4, 0, null),
      new Spell("Drain", 73, 2, 2, null),
      new Spell("Shield", 113, 0, 0, new Effect(EffectType.SHIELD, 6)),
      new Spell("Poison", 173, 0, 0, new Effect(EffectType.POISON, 6)),
      new Spell("Recharge", 229, 0, 0, new Effect(EffectType.RECHARGE, 5))
  );

  public static List<Spell> castableSpells(int playerMana, Set<Effect> activeEffects) {
    int usableMana = getManaAfterRestoration(playerMana, activeEffects);
    var nextEffects = getActiveEffectsAfterNextActivation(activeEffects);

    return SPELLS.stream().filter(spell -> !nextEffects.contains(spell.effect()))
        .filter(spell -> spell.cost() <= usableMana)
        .toList();
  }

  private static int getManaAfterRestoration(int playerMana, Set<Effect> activeEffects) {
    var restorationAmount = activeEffects.stream()
        .mapToInt(effect -> effect.getType().getManaRestoration()).sum();

    return playerMana + restorationAmount;
  }

  private static Set<Effect> getActiveEffectsAfterNextActivation(Set<Effect> activeEffects) {
    return activeEffects.stream()
        .filter(effect -> effect.getDuration() > 1)
        .collect(Collectors.toSet());
  }
}
