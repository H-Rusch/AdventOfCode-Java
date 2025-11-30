package aoc2015.day12;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Getter;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class JsonSumNumbers {

  private static final String FILTER = "red";

  @Getter
  private int sum;
  private final JsonNode root;

  public JsonSumNumbers(String jsonInput) {
    this.sum = 0;
    try {
      this.root = new ObjectMapper().readTree(jsonInput);
    } catch (JacksonException e) {
      throw new RuntimeException(e);
    }
  }

  public void sumWithoutRed() {
    sumWithoutRed(root);
  }

  private void sumWithoutRed(JsonNode node) {
    if (node == null || testSkipBasedOnProperty(node)) {
      return;
    }
    if (node.isInt()) {
      sum += node.asInt();
    }

    node.iterator().forEachRemaining(this::sumWithoutRed);
  }

  private boolean testSkipBasedOnProperty(JsonNode node) {
    if (!node.isObject()) {
      return false;
    }
    Stream<JsonNode> nodeStream = StreamSupport.stream(
        Spliterators.spliteratorUnknownSize(node.iterator(), Spliterator.ORDERED),
        false);

    return nodeStream.anyMatch(n -> n.isString() && n.stringValue().equals(FILTER));
  }
}
