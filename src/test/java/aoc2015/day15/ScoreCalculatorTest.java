package aoc2015.day15;

import org.junit.jupiter.api.Test;
import util.days.InputFetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreCalculatorTest {

    @Test
    void testScoreCalculationPart1() {
        String input = InputFetcher.loadExample(2015, 15);
        var ingredients = Day15.parseInput(input);
        var amounts = new int[]{44, 56};
        var calculator = new ScoreCalculator(ingredients);
        int expectedResult = 62842880;

        int result = calculator.calculateScore(amounts);

        assertEquals(expectedResult, result);
    }

    @Test
    void negativePropertyBecomesZero() {
        String input = InputFetcher.loadExample(2015, 15);
        var ingredients = Day15.parseInput(input);
        var amounts = new int[]{100, 0};
        var calculator = new ScoreCalculator(ingredients);
        int expectedResult = 0;

        int result = calculator.calculateScore(amounts);

        assertEquals(expectedResult, result);
    }

    @Test
    void trackMaxScoreCorrectly() {
        String input = InputFetcher.loadExample(2015, 15);
        var ingredients = Day15.parseInput(input);
        var calculator = new ScoreCalculator(ingredients);
        int expectedMaxScore = 62842880;

        calculator.calculateScore(new int[] {67, 33});
        int score1 = calculator.getMaxScore();
        calculator.calculateScore(new int[] {44, 56});
        int score2 = calculator.getMaxScore();
        calculator.calculateScore(new int[] {67, 33});
        int score3 = calculator.getMaxScore();

        assertEquals(expectedMaxScore, score2);
        assertTrue(score1 < score2);
        assertTrue(score3 == score2);
    }
}
