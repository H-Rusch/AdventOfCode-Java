package aoc2015.day15;

import static aoc.InputFetcherKt.loadExample;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

  @Test
  void testScoreCalculationPart1() {
    String input = loadExample(2015, "day15.txt");
    var ingredients = Day15.parseInput(input);
    var amounts = new int[]{44, 56};
    var calculator = new ScoreCalculator(ingredients);
    int expectedResult = 62842880;

    int result = calculator.calculateScore(amounts);

    assertEquals(expectedResult, result);
  }

  @Test
  void negativePropertyBecomesZero() {
    String input = loadExample(2015, "day15.txt");
    var ingredients = Day15.parseInput(input);
    var amounts = new int[]{100, 0};
    var calculator = new ScoreCalculator(ingredients);
    int expectedResult = 0;

    int result = calculator.calculateScore(amounts);

    assertEquals(expectedResult, result);
  }

  @Test
  void trackMaxScoreCorrectly() {
    String input = loadExample(2015, "day15.txt");
    var ingredients = Day15.parseInput(input);
    var calculator = new ScoreCalculator(ingredients);
    int expectedMaxScore = 62842880;

    calculator.calculateScore(new int[]{67, 33});
    int score1 = calculator.getMaxScore();
    calculator.calculateScore(new int[]{44, 56});
    int score2 = calculator.getMaxScore();
    calculator.calculateScore(new int[]{67, 33});
    int score3 = calculator.getMaxScore();

    assertEquals(expectedMaxScore, score2);
    assertTrue(score1 < score2);
    assertEquals(score3, score2);
  }
}
