package aoc2015.day15;

import aoc2015.Day2015;

public class Day15 extends Day2015 {

    public Day15() {
        super(15);
    }

    @Override
    public Object part1(String input) {
        var ingredients = parseInput(input);
        var calculator = new ScoreCalculator(ingredients);
        var generator = new SelectionGenerator(ingredients.length);

        var amounts = generator.generateSelections();
        amounts.forEach(calculator::calculateScore);

        return calculator.getMaxScore();
    }

    @Override
    public Object part2(String input) {
        var ingredients = parseInput(input);
        var calculator = new ScoreCalculator(ingredients);
        var generator = new SelectionGenerator(ingredients.length);
        var amountFilter = new AmountFilter(ingredients);

        var amounts = generator.generateSelections();
        amounts.stream().filter(amountFilter::hasGoalCalories)
                .forEach(calculator::calculateScore);

        return calculator.getMaxScore();
    }

    public static Ingredient[] parseInput(String input) {
        return input.lines()
                .map(IngredientParser::parseString)
                .toArray(Ingredient[]::new);
    }

    public static void main(String[] args) {
        new Day15().main();
    }
}
