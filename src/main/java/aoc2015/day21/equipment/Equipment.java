package aoc2015.day21.equipment;

public interface Equipment {

  int cost();

  default int damage() {
    return 0;
  }

  default int armor() {
    return 0;
  }
}
