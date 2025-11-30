package aoc2015.day22;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EffectType {

  SHIELD(0, 7, 0),
  POISON(3, 0, 0),
  RECHARGE(0, 0, 101);

  private final int damage;
  private final int armor;
  private final int manaRestoration;
}
