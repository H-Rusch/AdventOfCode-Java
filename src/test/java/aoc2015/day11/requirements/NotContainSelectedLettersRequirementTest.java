package aoc2015.day11.requirements;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NotContainSelectedLettersRequirementTest {

  @Test
  void examples() {
    assertFalse(new NotContainSelectedLettersRequirement().matches("hijklmmn"));
    assertTrue(new NotContainSelectedLettersRequirement().matches("abbceffg"));
    assertTrue(new NotContainSelectedLettersRequirement().matches("abbcegjk"));
  }
}
