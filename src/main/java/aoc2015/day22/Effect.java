package aoc2015.day22;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Effect {

  private EffectType type;
  private int duration;

  public void tick() {
    duration--;
  }

  public boolean isActive() {
    return duration > 0;
  }

  public Effect copy() {
    return new Effect(type, duration);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Effect effect = (Effect) o;
    return getType() == effect.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType());
  }
}
