package aoc15.day07;


import aoc15.AbstractDay2015;
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

class Day07 extends AbstractDay2015 {

  private final Map<String, Node> nodes;
  private static final String NUMBER_PATTERN = "\\d+";

  Day07() {
    super(7);
    nodes = new HashMap<>();
  }

  @NonNull
  @Override
  public Integer part1(@NonNull String input) {
    buildTree(input);

    return calculateValueForNode("a");
  }

  @NonNull
  @Override
  public Integer part2(@NonNull String input) {
    buildTree(input);
    int result = calculateValueForNode("a");

    buildTree(input);
    nodes.put("b", new Node(new Identity(result)));

    return calculateValueForNode("a");
  }

  protected void buildTree(String input) {
    input.lines().forEach(this::createWire);
  }

  private void createWire(String line) {
    String[] parts = line.split(" ");

    Node node = new Node();
    Operation op;
    if (parts.length == 3) { // value/ forwarder
      if (parts[0].matches(NUMBER_PATTERN)) {
        op = new Identity(Integer.parseInt(parts[0]));
      } else {
        op = new Forward(parts[0]);
      }
    } else if (parts.length == 4) { // negation
      op = new Not(parts[1]);
    } else { // and / or / shifts
      op = switch (parts[1]) {
        case "AND" -> new And(parts[0], parts[2]);
        case "OR" -> new Or(parts[0], parts[2]);
        case "RSHIFT" -> new RightShift(parts[0], Integer.parseInt(parts[2]));
        case "LSHIFT" -> new LeftShift(parts[0], Integer.parseInt(parts[2]));
        default -> null;
      };
    }
    node.setOperation(op);

    nodes.put(parts[parts.length - 1], node);
  }

  protected int calculateValueForNode(String key) {
    return nodes.get(key).calculate();
  }

  static class Node {

    Integer cached = null;
    Operation operation;

    public Node() {
    }

    public Node(Operation operation) {
      this.operation = operation;
    }

    public void setOperation(Operation operation) {
      this.operation = operation;
    }

    int calculate() {
      if (cached == null) {
        cached = operation.compute();
      }
      return cached;
    }
  }

  interface Operation {

    int compute();
  }

  static class Identity implements Operation {

    private final int value;

    public Identity(int value) {
      this.value = value;
    }

    @Override
    public int compute() {
      return value;
    }
  }

  class Forward implements Operation {

    private final String prev;

    public Forward(String prev) {
      this.prev = prev;
    }

    @Override
    public int compute() {
      return nodes.get(prev).calculate();
    }
  }

  class And implements Operation {

    private final String prev1;
    private final String prev2;

    public And(String prev1, String prev2) {
      this.prev1 = prev1;
      this.prev2 = prev2;
    }

    @Override
    public int compute() {
      int val1 =
          prev1.matches(NUMBER_PATTERN) ? Integer.parseInt(prev1) : nodes.get(prev1).calculate();
      int val2 =
          prev2.matches(NUMBER_PATTERN) ? Integer.parseInt(prev2) : nodes.get(prev2).calculate();

      return val1 & val2;
    }
  }

  class Or implements Operation {

    private final String prev1;
    private final String prev2;

    public Or(String prev1, String prev2) {
      this.prev1 = prev1;
      this.prev2 = prev2;
    }

    @Override
    public int compute() {
      int val1 =
          prev1.matches(NUMBER_PATTERN) ? Integer.parseInt(prev1) : nodes.get(prev1).calculate();
      int val2 =
          prev2.matches(NUMBER_PATTERN) ? Integer.parseInt(prev2) : nodes.get(prev2).calculate();

      return val1 | val2;
    }
  }

  class Not implements Operation {

    private final String prev;

    public Not(String prev) {
      this.prev = prev;
    }

    @Override
    public int compute() {
      return ~nodes.get(prev).calculate() & 0xffff;
    }
  }

  class RightShift implements Operation {

    private final String prev;
    private final int amount;

    public RightShift(String prev, int amount) {
      this.prev = prev;
      this.amount = amount;
    }

    @Override
    public int compute() {
      return nodes.get(prev).calculate() >> amount;
    }
  }

  class LeftShift implements Operation {

    private final String prev;
    private final int amount;

    public LeftShift(String prev, int amount) {
      this.prev = prev;
      this.amount = amount;
    }

    @Override
    public int compute() {
      return nodes.get(prev).calculate() << amount;
    }
  }

  public static void main(String[] args) {
    new Day07().executeParts();
  }
}
