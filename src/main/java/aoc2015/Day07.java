package aoc2015;


import java.util.HashMap;
import java.util.Map;

class Day07 extends Day {

    private final Map<String, Wire> wires;
    private final static String numberPattern = "\\d+";

    Day07() {
        super(7);
        wires = new HashMap<>();
    }

    @Override
    public String part1(String input) {
        buildTree(input);

        return String.valueOf(calculateValueForNode("a"));
    }

    @Override
    public String part2(String input) {
        buildTree(input);

        int result = calculateValueForNode("a");

        buildTree(input);
        wires.put("b", new Value(result));


        return String.valueOf(calculateValueForNode("a"));
    }

    protected void buildTree(String input) {
        input.lines().forEach(this::createWire);
    }

    private void createWire(String line) {
        String[] parts = line.split(" ");

        Wire wire;
        if (parts.length == 3) { // value/ forwarder
            if (parts[0].matches(numberPattern)) {
                wire = new Value(Integer.parseInt(parts[0]));
            } else {
                wire = new Forwarder(parts[0]);
            }
        } else if (parts.length == 4) { // negation
            wire = new NotGate(parts[1]);
        } else { // and / or / shifts
            wire = switch (parts[1]) {
                case "AND" -> new AndGate(parts[0], parts[2]);
                case "OR" -> new OrGate(parts[0], parts[2]);
                case "RSHIFT" -> new RightShiftGate(parts[0], Integer.parseInt(parts[2]));
                case "LSHIFT" -> new LeftShiftGate(parts[0], Integer.parseInt(parts[2]));
                default -> null;
            };
        }

        wires.put(parts[parts.length - 1], wire);
    }

    protected int calculateValueForNode(String key) {
        return wires.get(key).calculate();
    }

    /** Classes representing the different operations possible. */
    abstract class Wire {
        Integer cached = null;

        int calculateAndCache() {
            if (cached != null) {
                return cached;
            }

            int result = calculate();
            cached = result;

            return result;
        }

        abstract int calculate();
    }

    class Value extends Wire {
        private final int value;

        public Value(int value) {
            this.value = value;
        }

        @Override
        public int calculate() {
            return value;
        }
    }

    class Forwarder extends Wire {
        private final String prev;

        public Forwarder(String prev) {
            this.prev = prev;
        }

        @Override
        public int calculate() {
            return wires.get(prev).calculateAndCache();
        }
    }

    class AndGate extends Wire {
        private final String prev1;
        private final String prev2;

        public AndGate(String prev1, String prev2) {
            this.prev1 = prev1;
            this.prev2 = prev2;
        }

        @Override
        public int calculate() {
            int val1 = prev1.matches(numberPattern) ? Integer.parseInt(prev1) : wires.get(prev1).calculateAndCache();
            int val2 = prev2.matches(numberPattern) ? Integer.parseInt(prev2) : wires.get(prev2).calculateAndCache();

            return val1 & val2;
        }
    }

    class OrGate extends Wire {
        private final String prev1;
        private final String prev2;

        public OrGate(String prev1, String prev2) {
            this.prev1 = prev1;
            this.prev2 = prev2;
        }

        @Override
        public int calculate() {
            int val1 = prev1.matches(numberPattern) ? Integer.parseInt(prev1) : wires.get(prev1).calculateAndCache();
            int val2 = prev2.matches(numberPattern) ? Integer.parseInt(prev2) : wires.get(prev2).calculateAndCache();

            return val1 | val2;
        }
    }

    class NotGate extends Wire {
        private final String prev;

        public NotGate(String prev) {
            this.prev = prev;
        }

        @Override
        public int calculate() {
            return ~wires.get(prev).calculateAndCache() & 0xffff;
        }
    }

    class RightShiftGate extends Wire {
        private final String prev;
        private final int amount;

        public RightShiftGate(String prev, int amount) {
            this.prev = prev;
            this.amount = amount;
        }

        @Override
        public int calculate() {
            return wires.get(prev).calculateAndCache() >> amount;
        }
    }

    class LeftShiftGate extends Wire {
        private final String prev;
        private final int amount;

        public LeftShiftGate(String prev, int amount) {
            this.prev = prev;
            this.amount = amount;
        }

        @Override
        public int calculate() {
            int result = wires.get(prev).calculateAndCache() << amount;
            cached = result;

            return result;
        }
    }

    public static void main(String[] args) {
        new Day07().main();
    }
}
