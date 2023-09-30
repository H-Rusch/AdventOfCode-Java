package aoc2015.day19;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day19Test {

    @ParameterizedTest
    @MethodSource("provideMoleculesForPart1Example")
    void part1ExampleTest(String startingMolecule, int expectedLength) {
        var repl = new MoleculeReplacer(createExampleReplacementRules(), startingMolecule);

        var replacements = repl.getAllReplacements();

        assertEquals(expectedLength, replacements.size());
    }

    private static Stream<Arguments> provideMoleculesForPart1Example() {
        return Stream.of(
                Arguments.of("HOH", 4),
                Arguments.of("HOHOHO", 7)
        );
    }

    private Map<String, List<String>> createExampleReplacementRules() {
        return Map.of(
                "H", List.of("HO", "OH"),
                "O", List.of("HH")
        );
    }
}
