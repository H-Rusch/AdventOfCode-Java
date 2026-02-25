package util.combinations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import kotlin.Pair;
import kotlin.sequences.SequencesKt;
import org.junit.jupiter.api.Test;
import util.collections.CombinationUtil;
import util.collections.CombinationsKt;

class CombinationsTest {

    @Test
    void createCorrectCombinationsSize() {
        var values = List.of(1, 2, 3, 4);
        var combinator = new CombinationUtil<>(values);

        var combinations = combinator.combinations(2);

        assertThat(combinations).hasSize(6);
    }

    @Test
    void thatPairwiseBuildsAllTwoElementCombinations() {
        var input = List.of("foo", "bar", "baz");
        var expected = List.of(
                new Pair<>("foo", "bar"),
                new Pair<>("foo", "baz"),
                new Pair<>("bar", "foo"),
                new Pair<>("bar", "baz"),
                new Pair<>("baz", "foo"),
                new Pair<>("baz", "bar"));

        var result = SequencesKt.toList(CombinationsKt.pairwise(input));

        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void thatPairwiseReturnsEmptyStreamWhenGivenEmptyList() {
        var result = SequencesKt.toList(CombinationsKt.pairwise(List.of()));

        assertThat(result).isEmpty();
    }

    @Test
    void thatPairwiseReturnsEmptyStreamWhenGivenOnlyOneElement() {
        var result = SequencesKt.toList(CombinationsKt.pairwise(List.of("foo")));

        assertThat(result).isEmpty();
    }
}
