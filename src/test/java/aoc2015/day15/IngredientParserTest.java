package aoc2015.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientParserTest {

    @Test
    void parseIngredientCorrectly() {
        String toParse = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8";
        Ingredient expected = new Ingredient("Butterscotch", -1, -2, 6, 3, 8);

        Ingredient parsed = IngredientParser.parseString(toParse);

        assertEquals(expected.getName(), parsed.getName());
        assertEquals(expected.getCapacity(), parsed.getCapacity());
        assertEquals(expected.getDurability(), parsed.getDurability());
        assertEquals(expected.getFlavor(), parsed.getFlavor());
        assertEquals(expected.getTexture(), parsed.getTexture());
        assertEquals(expected.getCalories(), parsed.getCalories());
    }
}
