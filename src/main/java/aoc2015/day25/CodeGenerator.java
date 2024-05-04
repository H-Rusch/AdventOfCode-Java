package aoc2015.day25;

import java.util.ArrayList;
import java.util.List;
import util.grid.Point;
import util.math.SimpleMath;

public class CodeGenerator {

    private static final long INITIAL_VALUE = 20151125;
    private static final long FACTOR = 252533;
    private static final long DIVISOR = 33554393;

    private final List<Long> values;


    public CodeGenerator() {
        this.values = new ArrayList<>();
        values.add(INITIAL_VALUE);
    }

    public long calculateAt(Point point) {
        for (int i = 0; i < countCodes(point); i++) {
            updateNextValue();
        }

        return getLastValue();
    }

    protected int countCodes(Point point) {
        return SimpleMath.gaussianSum(point.x() + point.y() - 2) + point.y() - 1; // -2 because of start at (1, 1). -1 because
    }

    private void updateNextValue() {
        var nextValue = calculateNextValue(getLastValue());
        values.add(nextValue);
    }

    private long getLastValue() {
        return values.get(values.size() - 1);
    }

    protected long calculateNextValue(long lastValue) {
        return (lastValue * FACTOR) % DIVISOR;
    }
}
