package aoc2015.day15;

import java.util.regex.Pattern;
import util.regex.RegexHelper;

public class IngredientParser {

  private IngredientParser() {
  }

  // Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8
  private static final Pattern ingredientPattern = Pattern.compile(
      "(.*?): capacity (-?\\d+), durability (-?\\d+), flavor (-?\\d+), texture (-?\\d+), calories (-?\\d+)");

  public static Ingredient parseString(String string) {
    var match = ingredientPattern.matcher(string);
    var groups = RegexHelper.getGroups(match);

    return new Ingredient(
        groups.get(1),
        Integer.parseInt(groups.get(2)),
        Integer.parseInt(groups.get(3)),
        Integer.parseInt(groups.get(4)),
        Integer.parseInt(groups.get(5)),
        Integer.parseInt(groups.get(6))
    );
  }
}
