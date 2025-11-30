package aoc15.day11.requirements;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainTwoPairRequirementTest {

  @Test
  void examples() {
    assertFalse(new ContainTwoPairRequirement().matches("hijklmmn"));
    assertTrue(new ContainTwoPairRequirement().matches("abbceffg"));
    assertFalse(new ContainTwoPairRequirement().matches("abbcegjk"));
  }
}
