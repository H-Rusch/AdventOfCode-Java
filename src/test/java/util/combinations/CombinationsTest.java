package util.combinations;

import org.junit.jupiter.api.Test;
import util.collections.CombinationUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsTest {

    @Test
    void createCorrectCombinationsSize() {
        var values = createValueList();
        var combinator = new CombinationUtil<>(values);

        var combinations = combinator.combinations(2);

        assertEquals(6, combinations.size());
    }

    private List<Integer> createValueList() {
        return List.of(1, 2, 3, 4);
    }
}
