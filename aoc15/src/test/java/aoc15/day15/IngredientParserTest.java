package aoc15.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IngredientParserTest {

  @Test
  void parseIngredientCorrectly() {
    String toParse = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8";
    Ingredient expected = new Ingredient("Butterscotch", -1, -2, 6, 3, 8);

    Ingredient parsed = IngredientParser.parseString(toParse);

    assertEquals(expected.name(), parsed.name());
    assertEquals(expected.capacity(), parsed.capacity());
    assertEquals(expected.durability(), parsed.durability());
    assertEquals(expected.flavor(), parsed.flavor());
    assertEquals(expected.texture(), parsed.texture());
    assertEquals(expected.calories(), parsed.calories());
  }
}
