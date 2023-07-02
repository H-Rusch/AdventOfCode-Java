package aoc2015.day11.requirements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotContainSelectedLettersRequirementTest {

    @Test
    void examples() {
        assertFalse(new NotContainSelectedLettersRequirement().matches("hijklmmn"));
        assertTrue(new NotContainSelectedLettersRequirement().matches("abbceffg"));
        assertTrue(new NotContainSelectedLettersRequirement().matches("abbcegjk"));
    }
}
