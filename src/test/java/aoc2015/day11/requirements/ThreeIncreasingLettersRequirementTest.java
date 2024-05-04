package aoc2015.day11.requirements;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ThreeIncreasingLettersRequirementTest {

  @Test
  void examples() {
    assertTrue(new ThreeIncreasingRequirement().matches("hijklmmn"));
    assertFalse(new ThreeIncreasingRequirement().matches("abbceffg"));
    assertFalse(new ThreeIncreasingRequirement().matches("abbcegjk"));
  }
}
