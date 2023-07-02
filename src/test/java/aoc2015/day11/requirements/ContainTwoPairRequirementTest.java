package aoc2015.day11.requirements;

import aoc2015.day11.requirements.ContainTwoPairRequirement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainTwoPairRequirementTest {

    @Test
    void examples() {
        assertFalse(new ContainTwoPairRequirement().matches("hijklmmn"));
        assertTrue(new ContainTwoPairRequirement().matches("abbceffg"));
        assertFalse(new ContainTwoPairRequirement().matches("abbcegjk"));
    }
}
